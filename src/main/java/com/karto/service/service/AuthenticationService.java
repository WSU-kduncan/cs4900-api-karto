package com.karto.service.service;

import com.karto.service.dto.UserDto;
import com.karto.service.mapper.UserDtoMapper;
import com.karto.service.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationService implements AuthenticationProvider {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final UserDtoMapper userDtoMapper;
  private final UserService userService;

  public class JwtToken extends AbstractAuthenticationToken {
    public JwtToken(
        Object principal, String jwtToken, Collection<? extends GrantedAuthority> authorities) {
      super(authorities);
      this.principal = principal;
      this.jwtToken = jwtToken;
      setAuthenticated(true);
    }

    private final Object principal;
    private final String jwtToken;

    @Override
    public Object getCredentials() {
      return jwtToken;
    }

    @Override
    public Object getPrincipal() {
      return principal;
    }
  }

  @Value("${password-encoder.secret}")
  private String SECRET;

  public com.karto.service.model.User addUser(UserDto userDto) throws Exception {
    if (userRepository.existsById(userDto.getEmail()))
      throw new Exception("Duplicate Email for " + userDto.getEmail());
    if (userRepository.existsByUsername(userDto.getUsername()))
      throw new Exception("Duplicate Username for " + userDto.getUsername());
    var entity = userDtoMapper.toEntity(userDto);
    entity.setPassword(passwordEncoder.encode(entity.getPassword()));
    var back = userRepository.saveAndFlush(entity);
    return back;
  }

  public String generateToken(String email) {
    Map<String, Object> claims = new HashMap<>();
    return createToken(claims, email);
  }

  private SecretKey getSignKey() {
    byte[] keyBytes = Decoders.BASE64.decode(SECRET);
    return new SecretKeySpec(keyBytes, "AES");
  }

  public Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  private Claims extractAllClaims(String token) {
    return Jwts.parser()
        .verifyWith(getSignKey())
        .build()
        .parseEncryptedClaims(token)
        .getPayload();
  }

  private Boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  public Boolean validateToken(String token) {
    return isTokenExpired(token);
  }

  private String createToken(Map<String, Object> claims, String email) {
    return Jwts.builder()
        .claims(claims)
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
        .encryptWith(getSignKey(), Jwts.ENC.A256GCM)
        .compact();
  }

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String email = authentication.getName();
    String password = authentication.getCredentials().toString();

    var user = userService.getUserByEmail(email);
    if (!passwordEncoder.matches(password, user.getPassword())) {
      throw new BadCredentialsException("Invalid credentials");
    }

    String token = generateToken(email);
    return new JwtToken(user, token, new ArrayList<>());
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.equals(
        org.springframework.security.authentication.UsernamePasswordAuthenticationToken.class);
  }
}

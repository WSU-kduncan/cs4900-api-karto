package com.karto.service.service;

import com.karto.service.dto.LoginDto;
import com.karto.service.dto.UserDto;
import com.karto.service.mapper.UserDtoMapper;
import com.karto.service.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final UserDtoMapper userDtoMapper;

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

  public String login(LoginDto loginDto) throws Exception {
    var entity = userRepository
        .findById(loginDto.getEmail())
        .orElseThrow(() -> new Exception("No email found for " + loginDto.getEmail()));
    if (!passwordEncoder.matches(loginDto.getPassword(), entity.getPassword()))
      throw new Exception("Invalid Credentials");
    return generateToken(entity.getEmail());
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
}

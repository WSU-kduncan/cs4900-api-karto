package com.karto.service.service;

import com.karto.service.mapper.GasStationDtoMapper;
import com.karto.service.model.GasStation;
import com.karto.service.model.TrustedGasStation;
import com.karto.service.model.User;
import com.karto.service.model.composite.TrustedGasStationId;
import com.karto.service.repository.GasStationRepository;
import com.karto.service.repository.TrustedGasStationRepository;
import com.karto.service.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  private final TrustedGasStationRepository trustedGasStationRepository;

  private final GasStationRepository gasStationRepository;

  private final GasStationDtoMapper gasStationDtoMapper;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserByEmail(String email) throws EntityNotFoundException {
    Optional<User> user = userRepository.findById(email);
    if (user.isEmpty()) {
      throw new EntityNotFoundException("User not found with email: " + email);
    }
    return user.get();
  }

  public User getUserByUsername(String username) throws EntityNotFoundException {
    Optional<User> user = userRepository.findByUsername(username);
    if (user.isEmpty()) {
      throw new EntityNotFoundException("User not found with username: " + username);
    }
    return user.get();
  }

  public List<GasStation> getGasStationByUser(User user) {
    var trustedGasStations = trustedGasStationRepository.findByUser(user);
    return trustedGasStations.stream().map(g -> g.getGasStation()).toList();
  }

  public TrustedGasStation addTrustedGasStation(String email, Integer gasStationId)
      throws EntityExistsException, EntityNotFoundException {
    User user = getUserByEmail(email);
    GasStation gasStation = gasStationRepository.findById(gasStationId).orElse(null);
    if (user == null || gasStation == null) {
      throw new EntityNotFoundException(
          "User not found with email: " + email + " or gas station ID: " + gasStationId);
    }

    List<Integer> gasStationIds =
        trustedGasStationRepository.findTrustedGasStationStationIdsByUserEmail(email);
    if (gasStationIds.contains(gasStationId)) {
      throw new EntityExistsException("Gas Station is already trusted for email: " + email);
    }

    TrustedGasStationId trustedGasStationId = new TrustedGasStationId(email, gasStationId);
    TrustedGasStation trustedGasStation =
        new TrustedGasStation(trustedGasStationId, user, gasStation);

    return trustedGasStationRepository.saveAndFlush(trustedGasStation);
  }

  public TrustedGasStation putTrustedGasStation(
      String email, Integer oldGasStationId, Integer newGasStationId)
      throws EntityNotFoundException {
    User user = getUserByEmail(email);

    GasStation oldGasStation = gasStationRepository.findById(oldGasStationId).orElse(null);
    TrustedGasStation oldTrustedGasStation =
        trustedGasStationRepository.findByUserAndGasStation(user, oldGasStation);

    if (user == null || oldGasStation == null) {
      throw new EntityNotFoundException("User/GasStation not found with email: " + email);
    }

    if (oldTrustedGasStation == null) {
      throw new EntityNotFoundException(
          "TrustedGasStation could not be found with GasStation body or email: " + email);
    }

    trustedGasStationRepository.delete(oldTrustedGasStation);

    GasStation newGasStation = gasStationRepository
        .findById(newGasStationId)
        .orElseThrow(() -> new EntityNotFoundException("Gas station Id not found"));
    TrustedGasStationId trustedGasStationId = new TrustedGasStationId(email, newGasStationId);
    TrustedGasStation newTrustedGasStation =
        new TrustedGasStation(trustedGasStationId, user, newGasStation);

    return trustedGasStationRepository.saveAndFlush(newTrustedGasStation);
  }
}

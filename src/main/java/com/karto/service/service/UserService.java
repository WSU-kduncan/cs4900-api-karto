package com.karto.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.karto.service.model.User;
import com.karto.service.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

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
}
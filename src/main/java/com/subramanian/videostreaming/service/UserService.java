package com.subramanian.videostreaming.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.subramanian.videostreaming.entity.User;
import com.subramanian.videostreaming.repository.UserRepository;
import com.subramanian.videostreaming.security.JwtUtil;

import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;
import com.subramanian.videostreaming.dto.LoginRequest;



@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

public UserService(UserRepository userRepository,
                   PasswordEncoder passwordEncoder,
                   JwtUtil jwtUtil) {

    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtUtil = jwtUtil;
}

    // Register User
    public User registerUser(User user) {

    user.setPassword(passwordEncoder.encode(user.getPassword()));

    return userRepository.save(user);
}

    // Get All Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get User By ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Update User
    public User updateUser(Long id, User updatedUser) {

        User existingUser = userRepository.findById(id).orElse(null);

        if (existingUser != null) {
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(
        passwordEncoder.encode(updatedUser.getPassword()));

            return userRepository.save(existingUser);
        }

        return null;
    }
    // Delete User
public String deleteUser(Long id) {

    if (userRepository.existsById(id)) {
        userRepository.deleteById(id);
        return "User deleted successfully!";
    }

    return "User not found!";
}
public String loginUser(LoginRequest loginRequest) {

    Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());

    if (user.isPresent()) {

        if (passwordEncoder.matches(
                loginRequest.getPassword(),
                user.get().getPassword())) {

            return jwtUtil.generateToken(loginRequest.getEmail());
        }
    }

    return "Invalid Email or Password";
}
}
    

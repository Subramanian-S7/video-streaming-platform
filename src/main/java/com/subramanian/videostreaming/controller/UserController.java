package com.subramanian.videostreaming.controller;

import com.subramanian.videostreaming.entity.User;
import com.subramanian.videostreaming.service.UserService;
import com.subramanian.videostreaming.dto.LoginRequest;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
    @GetMapping
    public List<User> getAllUsers() {
    return userService.getAllUsers();
}
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
    return userService.getUserById(id);
}
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,
                       @RequestBody User user) {

    return userService.updateUser(id, user);
}
    @DeleteMapping("/{id}")
public String deleteUser(@PathVariable Long id) {
    return userService.deleteUser(id);
}
  @PostMapping("/login")
public String loginUser(@RequestBody LoginRequest loginRequest) {

    System.out.println("******** LOGIN API HIT ********");

    return userService.loginUser(loginRequest);
}

}
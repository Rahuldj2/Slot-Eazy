package com.sloteazy.app.controller;


import com.sloteazy.app.models.User;
import com.sloteazy.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //This will be called when users signs in for first time
    @PostMapping("/insertUser")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/deleteUserByEmail")
    public ResponseEntity<Map<String, String>> deleteUserByEmail(@RequestParam String email)
    {
        userService.deleteUserByEmail(email);
        Map<String, String> response = new HashMap<>();
        response.put("message", "User deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getUserIdByEmail")
    public Long getUserIdByEmail(@RequestParam String email)
    {
        return userService.getUserIdByEmail(email);
    }
}

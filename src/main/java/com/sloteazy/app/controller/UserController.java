package com.sloteazy.app.controller;


import com.sloteazy.app.models.User;
import com.sloteazy.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/insertUser")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}

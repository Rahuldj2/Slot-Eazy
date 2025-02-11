package com.sloteazy.app.service;


import com.sloteazy.app.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User saveUser(User user);
    Long getUserIdByEmail(String email);
    void deleteUserByEmail(String email);

}
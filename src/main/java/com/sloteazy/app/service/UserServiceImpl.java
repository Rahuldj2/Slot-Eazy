package com.sloteazy.app.service;

import com.sloteazy.app.dao.UserRepository;
import com.sloteazy.app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Long getUserIdByEmail(String email) {
        return userRepository.findUserIdByEmail(email);
    }

    @Override
    public void deleteUserByEmail(String email)
    {

        userRepository.deleteUserByEmail(email);
    }


}


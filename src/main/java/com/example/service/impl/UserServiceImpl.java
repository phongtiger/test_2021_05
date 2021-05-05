package com.example.service.impl;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findByUserName(String userName) {
        return userRepository.findUsersByUserName(userName);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}

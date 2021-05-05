package com.example.service.impl;

import com.example.model.User;

public interface UserService {
    User findByUserName(String userName);
    void save(User user);
}

package com.example.service.impl;

import com.example.model.UserInfo;

public interface UserInfoService {
    UserInfo findByUserName(String useName);
    void save(UserInfo userInfo);
}

package com.example.service.impl;

import com.example.model.UserInfo;
import com.example.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    public UserInfo findByUserName(String useName) {
        return userInfoRepository.findUserInfoByUserName(useName);
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }
}

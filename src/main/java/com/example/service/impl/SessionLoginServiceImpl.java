package com.example.service.impl;

import com.example.model.SessionLogin;
import com.example.repository.SessionLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionLoginServiceImpl implements SessionLoginService {
    @Autowired
    private SessionLoginRepository sessionLoginRepository;
    @Override
    public void save(SessionLogin sessionLogin) {
        sessionLoginRepository.save(sessionLogin);
    }
}

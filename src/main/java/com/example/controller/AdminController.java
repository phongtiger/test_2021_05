package com.example.controller;

import com.example.model.*;
import com.example.service.impl.SessionLoginService;
import com.example.service.impl.UserInfoService;
import com.example.service.impl.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin("*")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private SessionLoginService sessionLoginService;

    @PostMapping("/login")
    public Output login(@RequestBody UserDTO userDTO) {
        Output output = new Output();
        User user = userService.findByUserName(userDTO.getUserName());
        if (Objects.isNull(user)) {
            output.setErrorCode("500");
            output.setDescription("Khong tim thay thong tin user voi user name" + userDTO.getUserName());
            return output;
        }
        output.setErrorCode("500");
        output.setDescription("Dang nhap that bai vui long thu lai");
        if (Strings.isNotEmpty(userDTO.getPassWord()) && userDTO.getPassWord().equals(user.getPassWord())) {
            SessionLogin sessionLogin = new SessionLogin();
            sessionLogin.setStatus("1");
            sessionLogin.setUserName(user.getUserName());
            sessionLoginService.save(sessionLogin);
            output.setErrorCode("200");
            output.setDescription("Dang nhap thanh cong");
            UserInfo userInfo = userInfoService.findByUserName(user.getUserName());
            output.setUserInfo(userInfo);
            return output;
        }
        return output;
    }

    @PostMapping("/register")
    public Output register(@RequestBody UserDTO userDTO) {
        User user = new User();
        Output output = new Output();
        User user1 = userService.findByUserName(userDTO.getUserName());
        if (!Objects.isNull(user1)) {
            output.setErrorCode("500");
            output.setDescription("Da ton tai username" + userDTO.getUserName());
            return output;
        }
        user.setPassWord(userDTO.getPassWord());
        user.setUserName(userDTO.getUserName());
        userService.save(user);
        UserInfo userInfo = new UserInfo();
        userInfo.setAddress(userDTO.getAddress());
        userInfo.setFullName(userDTO.getFullName());
        userInfo.setUserName(userDTO.getUserName());
        userInfoService.save(userInfo);
        output.setErrorCode("200");
        output.setDescription("Dang ky thanh cong");
        return output;
    }
}

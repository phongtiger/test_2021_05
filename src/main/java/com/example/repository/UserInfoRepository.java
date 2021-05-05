package com.example.repository;

import com.example.model.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
    UserInfo findUserInfoByUserName(String userName);
}

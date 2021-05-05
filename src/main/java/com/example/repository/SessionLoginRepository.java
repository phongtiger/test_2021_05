package com.example.repository;

import com.example.model.SessionLogin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionLoginRepository extends CrudRepository<SessionLogin, Long> {
}

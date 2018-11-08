package org.quickstart.spring.boot.druid.demo.service;


import org.quickstart.spring.boot.druid.demo.model.User;

public interface UserService {
    User findById(Long id);
}

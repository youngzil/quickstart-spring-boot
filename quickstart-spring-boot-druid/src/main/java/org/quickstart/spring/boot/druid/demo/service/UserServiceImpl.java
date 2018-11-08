package org.quickstart.spring.boot.druid.demo.service;


import org.quickstart.spring.boot.druid.demo.dao.UserDao;
import org.quickstart.spring.boot.druid.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findById(Long id) {
        return userDao.findOne(id);
    }

}

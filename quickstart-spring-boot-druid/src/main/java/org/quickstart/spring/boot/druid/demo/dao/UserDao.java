package org.quickstart.spring.boot.druid.demo.dao;


import org.quickstart.spring.boot.druid.demo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {}


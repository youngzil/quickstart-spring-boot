package org.quickstart.spring.boot.druid.demo.configurer;

import javax.annotation.PostConstruct;
import org.quickstart.spring.boot.druid.demo.dao.UserDao;
import org.quickstart.spring.boot.druid.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("default")
public class InitConfigurer{
    @Autowired
    private UserDao userDao;

    @PostConstruct
    public  void  init(){
        for (int i = 1; i <= 100; i++) {
            userDao.save(new User("TEST-NAME-" + i));
        }
    }
}

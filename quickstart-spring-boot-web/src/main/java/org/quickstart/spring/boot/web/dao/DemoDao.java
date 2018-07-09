/**
 * 项目名称：msgframe-console3 
 * 文件名：DemoDao.java
 * 版本信息：
 * 日期：2017年7月5日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.quickstart.spring.boot.web.entity.DemoUser;

/**
 * DemoDao
 * 
 * @author：yangzl@asiainfo.com
 * @2017年7月5日 下午6:32:14
 * @version 1.0
 */
@Mapper
public interface DemoDao {

    /*@Results({ // 2
    		@Result(property = "id", column = "id"), // 2
    		@Result(property = "name", column = "name"), 
    		@Result(property = "age", column = "age")
    		})
    
    @Select("SELECT * FROM demo_user WHERE age = #{age}") // 3
    List<DemoUser> get(int age);
    
    @Insert("INSERT INTO user(name, age) VALUES (#{name}, #{age})") // 3
    void insert(DemoUser demoUser);*/

    // 根据age查找info
    List<DemoUser> getUser(@Param("name") String name, @Param("age") String age);

    List<DemoUser> getAllUsers();

    int addUser(DemoUser user);

    int updateUser(DemoUser user);

    int deleteUser(String id);

}

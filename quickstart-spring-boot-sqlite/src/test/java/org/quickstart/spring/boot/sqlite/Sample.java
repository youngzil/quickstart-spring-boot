/**
 * 项目名称：quickstart-sqlite 
 * 文件名：Sample.java
 * 版本信息：
 * 日期：2018年11月11日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Sample
 * 
 * @author：youngzil@163.com
 * @2018年11月11日 上午11:09:05
 * @since 1.0
 */
public class Sample {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/sqliteData/myDb");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists hello");
            statement.executeUpdate("create table hello (id INTEGER primary key, title varchar(150),text  TEXT)");
            statement.executeUpdate("insert into hello(id,title,text) values(1,'yunlingfly','hhhh')");
            statement.executeUpdate("insert into hello(id,title,text) values(2,'test','ssss')");
            ResultSet rs = statement.executeQuery("select * from hello");
            while (rs.next()) {
                // read the result set
                System.out.println("id = " + rs.getInt("id"));
                System.out.println("title = " + rs.getString("title"));
                System.out.println("text = " + rs.getString("text"));
            }
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }
}

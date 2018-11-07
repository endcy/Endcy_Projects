package com.endcy.springcloudconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/8/24.
 * Version      : 1.0
 * ***************************************************************************
 */
@RestController
public class IndexController {

    @Autowired
    DataSource dataSource;

    @RequestMapping("/")
    public String home() {
        String time = "";
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select to_char(sysdate,'yyyymmddhh24miss') from dual");
            ResultSet resultSet = preparedStatement.executeQuery();
            time = resultSet.next() + "";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return time;
    }

}

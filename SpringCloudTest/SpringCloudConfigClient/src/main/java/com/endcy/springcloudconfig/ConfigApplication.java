package com.endcy.springcloudconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/8/24.
 * Version      : 1.0
 * ***************************************************************************
 */
@SpringBootApplication
public class ConfigApplication {

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(ConfigApplication.class, args);
//        Connection connection = null;
//        try {
//            DataSource dataSource = app.getBean(DataSource.class);
//            connection = dataSource.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        if (connection == null)
//            System.out.println("get DBConnection Error!");
//        try {
//            PreparedStatement prepareStatement = connection.prepareStatement("select to_char(sysdate,'YYYY-MM-DD HH24:Mi:SS') as timenow from dual");
//            ResultSet resultSet = prepareStatement.executeQuery();
//            System.out.println(resultSet.next());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

}

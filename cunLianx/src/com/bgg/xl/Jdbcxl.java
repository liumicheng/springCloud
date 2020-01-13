package com.bgg.xl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Jdbcxl {
    public static void main(String[] args) {
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC", "root", "");
            PreparedStatement pst = connection.prepareStatement("select * from user where name = ?");
            pst.setInt(1,1);
            ResultSet resultSet = pst.executeQuery();
            resultSet.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

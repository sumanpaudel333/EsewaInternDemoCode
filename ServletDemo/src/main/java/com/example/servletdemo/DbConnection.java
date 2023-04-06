package com.example.servletdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
static Connection conn;
public static Connection connectionProvider() throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.jdbc.Driver");
    String url="jdbc:mysql://localhost:3306/jdbc_demo";
    String user="root";
    String pass="paudel123";
    conn= DriverManager.getConnection(url,user,pass);
    return conn;
}
}

package com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class databaseconn {
public static Connection openConnection() {
Connection conn = null;
String dbURL = "jdbc:mysql://localhost:3306/ip-project";
String username = "root";
String password = "1234";
try {
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(dbURL,username,password);
System.out.println("connection successfully opened");
}catch (SQLException ex) {
ex.printStackTrace();
}catch (ClassNotFoundException ex) {
ex.printStackTrace();
}
return conn;
}
}



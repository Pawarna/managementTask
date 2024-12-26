package com.managementtask.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/taskdb"; 
    private static final String USER = "root";
    private static final String PASSWORD = ""; 
    
    public static Connection connect() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e){
            System.err.println("Koneksi Database Gagal : "+ e.getMessage());
            throw new SQLException("Database Connection Failed", e);
        }
    }  
}

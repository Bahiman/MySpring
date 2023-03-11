package com.example.myspringproject.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/spring_schema";

    private final String DATABASE_USER = "root";

    private final String DATABASE_PASSWORD = "11111";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
    }
}

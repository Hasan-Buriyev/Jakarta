package com.oss.lesson_7.back.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class JDBC {

    public static Connection getConnection() throws Exception {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://%s:%s/%s".formatted(Properties.DB_HOST, Properties.DB_PORT, Properties.DB_NAME);
        return DriverManager.getConnection(url, Properties.DB_USER, Properties.DB_PASSWORD);

    }
}

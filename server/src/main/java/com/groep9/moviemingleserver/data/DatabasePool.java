package com.groep9.moviemingleserver.data;

import com.groep9.moviemingleserver.MovieMingleServer;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabasePool {

    private static final Logger log = Logger.getLogger("DatabasePool");
    private static HikariDataSource dataSource;

    public static void initialize() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(MovieMingleServer.CONFIG.getDatabaseURL());
        config.setUsername(MovieMingleServer.CONFIG.getDatabaseUser());
        config.setPassword(MovieMingleServer.CONFIG.getDatabasePassword()); // TODO load from file

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            log.severe("Failed to take connection");
            throw new RuntimeException();
        }
    }
}

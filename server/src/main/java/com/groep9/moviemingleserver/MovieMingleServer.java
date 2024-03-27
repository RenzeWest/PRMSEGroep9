package com.groep9.moviemingleserver;

import com.groep9.moviemingleserver.data.DatabasePool;
import com.groep9.moviemingleserver.util.Config;
import org.springframework.boot.SpringBootConfiguration;

import java.sql.SQLException;


@SpringBootConfiguration
public class MovieMingleServer {

    public static Config CONFIG;
    public static void main(String[] args) {

        CONFIG = new Config();
        DatabasePool.initialize();

        try {
            DatabasePool.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
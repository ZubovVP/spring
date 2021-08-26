package ru.zubov;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Hello world!
 */

public class App {
    private static final Logger LOGGER =  LoggerFactory.getLogger(App.class);
    private Connection connection;

    public App() {
        initConnection();
    }

    private void initConnection() {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("settings.properties")) {
            Properties props = new Properties();
            props.load(in);
            Class.forName(props.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
            this.connection.setAutoCommit(false);
            LOGGER.info("--------CONNECTION TO DATABASE - COMPLETE--------");
        } catch (Exception e) {
            LOGGER.info("--------CONNECTION TO DATABASE - ERROR--------");
            LOGGER.error(e.getMessage(), e);
        }
    }


    public static void main(String[] args) {
        App app = new App();
    }

}

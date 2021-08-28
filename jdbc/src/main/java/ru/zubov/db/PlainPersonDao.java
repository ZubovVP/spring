package ru.zubov.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.zubov.App;
import ru.zubov.models.Person;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 28.08.2021.
 */
public class PlainPersonDao implements PersonDao, Closeable {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    private Connection connection;

    private Connection getConnection() {
        if (this.connection == null) {
            initConnection();
        }
        return this.connection;
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

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public List<Person> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public String findFirstNameById(int id) {
        return null;
    }

    @Override
    public String findLastNameById(int id) {
        return null;
    }

    @Override
    public void add(Person element) {

    }

    @Override
    public Person update(Person element) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() throws IOException {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException throwables) {
                LOGGER.error(throwables.getMessage(), throwables);
            }
        }
    }
}

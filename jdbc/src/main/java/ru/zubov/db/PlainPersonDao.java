package ru.zubov.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.zubov.models.Person;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 28.08.2021.
 */
public class PlainPersonDao implements PersonDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlainPersonDao.class);

    private Connection getConnection() {
        Connection connection = null;
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("settings.properties")) {
            Properties props = new Properties();
            props.load(in);
            Class.forName(props.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
            connection.setAutoCommit(false);
            LOGGER.info("--------CONNECTION TO DATABASE - COMPLETE--------");
        } catch (Exception e) {
            LOGGER.info("--------CONNECTION TO DATABASE - ERROR--------");
            LOGGER.error(e.getMessage(), e);
        }
        return connection;
    }

    @Override
    public List<Person> findAll() {
        List<Person> result = new ArrayList<>();
        LOGGER.info("--------GET ALL PERSONS - START--------");
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM persons");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setFirst_name(resultSet.getString("first_name"));
                person.setLast_name(resultSet.getString("last_name"));
                person.setBirthDate(resultSet.getDate("birth_date"));
                result.add(person);
            }
        } catch (SQLException throwables) {
            LOGGER.error(throwables.getMessage(), throwables);
        }
        LOGGER.info("--------GET ALL PERSONS - COMPLETE--------");
        return result;
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
        LOGGER.info("--------ADD PERSON IN A TABLE OF PERSONS - START--------");
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO persons (first_name, last_name, birth_date) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, element.getFirst_name());
            statement.setString(2, element.getLast_name());
            statement.setDate(3, element.getBirthDate());
            statement.executeUpdate();
            ResultSet generatedKey = statement.getGeneratedKeys();
            if (generatedKey.next()) {
                element.setId(generatedKey.getInt(1));
            }
            connection.commit();
        } catch (SQLException throwables) {
            LOGGER.error(throwables.getMessage(), throwables);
        }
        LOGGER.info("--------ADD PERSON IN A TABLE OF PERSONS - COMPLETE--------");
    }

    @Override
    public Person update(Person element) {
        return null;
    }

    @Override
    public void delete(int id) {
        LOGGER.info("--------DELETE PERSON FROM A TABLE OF PERSONS - START--------");
        try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM persons WHERE id =?")){
            statement.setInt(1, id);
            statement.execute();
            connection.commit();
        } catch (SQLException throwables) {
            LOGGER.error(throwables.getMessage(), throwables);
        }
        LOGGER.info("--------DELETE PERSON FROM A TABLE OF PERSONS - COMPETE--------");
    }
}

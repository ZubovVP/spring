package ru.zubov.db;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.zubov.models.Person;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 02.09.2021.
 */
public class JdbcPersonDao implements PersonDao, InitializingBean {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    @Override
    public String findLastNameById(int id) {
        return this.jdbcTemplate.queryForObject("SELECT last_name FROM persons WHERE id = ?", String.class, new Object[]{id});
    }

    @Override
    public List<Person> findAll() {
        String sql = "SELECT id, first_name, last_name, birth_date FROM persons";
        return this.jdbcTemplate.query(sql, (resultSet, i) -> {
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setFirst_name(resultSet.getString("first_name"));
            person.setLast_name(resultSet.getString("last_name"));
            person.setBirthDate(resultSet.getDate("birth_date"));
            return person;
        });
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanCreationException("DataSource must be not null");
        }
    }
}

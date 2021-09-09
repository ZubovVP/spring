package ru.zubov.db;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.zubov.models.Contact;
import ru.zubov.models.Model;
import ru.zubov.models.Person;


import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public List<Person> findAllWithDetail() {
        String sql = "SELECT p.id, p.first_name, p.last_name, p.birth_date, c.id AS contact_id, c.person_id, c.telephone_number, m.id AS model_id, m.model FROM contacts AS c" +
                "     LEFT JOIN persons AS p ON  p.id = c.person_id" +
                "     LEFT JOIN models m on c.model_id = m.id;";
        return this.jdbcTemplate.query(sql, resultSet -> {
            Map<Integer, Person> personMap = new HashMap<>();
            Person person;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                if (id == 0) {
                    id = resultSet.getInt("person_id");
                }
                person = personMap.get(id);
                if (person == null) {
                    person = new Person();
                    person.setId(id);
                    person.setFirst_name(resultSet.getString("first_name"));
                    person.setLast_name(resultSet.getString("last_name"));
                    person.setBirthDate(resultSet.getDate("birth_date"));
                    person.setContacts(new ArrayList<>());
                    personMap.put(id, person);
                }
                int contactId = resultSet.getInt("contact_id");
                if (contactId > 0) {
                    Contact contact = new Contact();
                    contact.setId(contactId);
                    contact.setPerson(person);
                    contact.setTelephone_number(resultSet.getString("telephone_number"));
                    contact.setModel(new Model(resultSet.getInt("model_id"), resultSet.getString("model")));
                    person.getContacts().add(contact);
                }
            }
            return personMap.values().stream().collect(Collectors.toList());
        });
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanCreationException("DataSource must be not null");
        }
    }
}

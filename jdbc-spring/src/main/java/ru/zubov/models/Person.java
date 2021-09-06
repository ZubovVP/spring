package ru.zubov.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 27.08.2021.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int id;
    private String first_name;
    private String last_name;
    private Date birthDate;
    private List<Contact> contacts;
}

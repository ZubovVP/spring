package ru.zubov.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.sql.Date;
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
public class Person {
    private int id;
    private String first_name;
    private String last_name;
    private Date birthDate;
    private List<Contact> contacts;
}

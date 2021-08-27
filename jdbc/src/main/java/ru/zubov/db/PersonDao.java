package ru.zubov.db;

import ru.zubov.models.Person;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 27.08.2021.
 */
public interface PersonDao extends SimpleAction<Person> {
    List<Person> findAll();

    List<Person> findByFirstName(String firstName);

    String findFirstNameById(int id);

    String findLastNameById(int id);
}

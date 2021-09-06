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
public interface PersonDao {

    String findLastNameById(int id);

    List<Person> findAll();

}

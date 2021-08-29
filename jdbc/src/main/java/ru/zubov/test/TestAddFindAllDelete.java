package ru.zubov.test;

import ru.zubov.db.PersonDao;
import ru.zubov.db.PlainPersonDao;
import ru.zubov.models.Person;

import java.sql.Date;
import java.util.GregorianCalendar;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 29.08.2021.
 */
public class TestAddFindAllDelete {
    private static final PersonDao personDao = new PlainPersonDao();

    public static void main(String[] args) {
        System.out.println("Начальный список людей");
        listAllPerson();
        System.out.println("-----------------");
        System.out.println("Вставка нового человека в БД");
        Person person = new Person();
        person.setFirst_name("Tom");
        person.setLast_name("Smith");
        person.setBirthDate(new Date(
                (new GregorianCalendar(2001,10, 1)).getTime().getTime()));
        personDao.add(person);
        listAllPerson();
        System.out.println("-----------------");
        System.out.println("Удаление созданного человека из БД");
        personDao.delete(person.getId());
        listAllPerson();
    }

    private static void listAllPerson() {
        for (Person person : personDao.findAll()) {
            System.out.println(person);
        }
    }
}

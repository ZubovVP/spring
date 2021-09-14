package ru.zubov.db.testForXml;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.zubov.db.PersonDao;
import ru.zubov.models.Person;

import java.sql.Date;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $Id$.
 * Date: 14.09.2021.
 */
public class TestJdbcPersonDaoAdd {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "app-context-xml.xml");
        PersonDao personDao = context.getBean("personDao", PersonDao.class);
        for (Person person : personDao.findAll()) {
            System.out.println(person);
        }
        Person personNew = new Person();
        personNew.setFirst_name("Mike");
        personNew.setLast_name("Petrov");
        personNew.setBirthDate(new Date(System.currentTimeMillis()));
        personDao.add(personNew);
        System.out.println("Add new person");
        for (Person person : personDao.findAll()) {
            System.out.println(person);
        }
    }
}

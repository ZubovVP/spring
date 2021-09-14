package ru.zubov.db.testForXml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.zubov.db.PersonDao;
import ru.zubov.models.Person;


/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $Id$.
 * Date: 14.09.2021.
 */
public class TestJdbcPersonDaoUpdate {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "app-context-xml.xml");
        PersonDao personDao = context.getBean("personDao", PersonDao.class);
        Person aimPerson = null;
        System.out.println("Last name person with id = 1 is - " + personDao.findLastNameById(1));
        for (Person person : personDao.findAllWithDetail()) {
            if(person.getId() == 1){
                aimPerson = person;
            }
        }
        System.out.println("Update last name for person with id = 1.");
        aimPerson.setLast_name("Ivanov");
        personDao.update(aimPerson);
        System.out.println("Last name person with id = 1 is - " + personDao.findLastNameById(1));
    }
}

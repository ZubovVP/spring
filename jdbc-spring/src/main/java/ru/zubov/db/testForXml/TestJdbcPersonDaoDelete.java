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
public class TestJdbcPersonDaoDelete {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "app-context-xml.xml");
        PersonDao personDao = context.getBean("personDao", PersonDao.class);
        for (Person person : personDao.findAll()) {
            System.out.println(person);
        }
        personDao.delete(1);
        System.out.println("Delete person with id = 1");
        for (Person person : personDao.findAll()) {
            System.out.println(person);
        }
    }
}

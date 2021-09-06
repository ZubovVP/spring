package ru.zubov;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.zubov.db.PersonDao;
import ru.zubov.models.Person;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 06.09.2021.
 */
public class TestJdbcPersonDaoFindAll {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "app-context-xml.xml");
        PersonDao personDao = context.getBean("personDao", PersonDao.class);
        for (Person person : personDao.findAll()) {
            System.out.println(person);
        }
    }
}

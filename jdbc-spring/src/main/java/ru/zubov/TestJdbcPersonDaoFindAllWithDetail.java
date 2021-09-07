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
 * Date: 07.09.2021.
 */
public class TestJdbcPersonDaoFindAllWithDetail {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "app-context-xml.xml");
        PersonDao personDao = context.getBean("personDao", PersonDao.class);
        for (Person person : personDao.findAllWithDetail()) {
            System.out.println(person);
        }
    }
}

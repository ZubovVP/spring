package ru.zubov.scope.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.zubov.scope.xml.Person;


/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 09.08.2021.
 */
@Configuration
@ComponentScan("ru.zubov.scope.annotation")
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
        System.out.println("Test singleton bean :");
        PersonSingleton personSingleton = context.getBean(PersonSingleton.class);
        System.out.println(personSingleton.getName());
        personSingleton.setName("Duke");
        personSingleton = context.getBean(PersonSingleton.class);
        System.out.println(personSingleton.getName());

        System.out.println("Test prototype bean:");
        PersonPrototype personPrototype = context.getBean(PersonPrototype.class);
        System.out.println(personPrototype.getName());
        personPrototype.setName("Duke");
        personPrototype = context.getBean(PersonPrototype.class);
        System.out.println(personPrototype.getName());
    }
}

package ru.zubov.scope.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 07.08.2021.
 */
public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-contextForScopes.xml");
        System.out.println("Test singleton bean :");
        Person person = (Person) context.getBean("personSingleton");
        System.out.println(person.getName());
        person.setName("Duke");
        person = (Person) context.getBean("personSingleton");
        System.out.println(person.getName());

        System.out.println("Test prototype bean:");
        person = (Person) context.getBean("personPrototype");
        System.out.println(person.getName());
        person.setName("Duke");
        person = (Person) context.getBean("personPrototype");
        System.out.println(person.getName());
    }
}

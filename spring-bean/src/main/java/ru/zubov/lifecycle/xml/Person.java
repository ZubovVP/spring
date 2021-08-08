package ru.zubov.lifecycle.xml;


/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 07.08.2021.
 */
public class Person {
    private Person() {
    }

    public static Person createPerson() {
        System.out.println("Create Person");
        return new Person();
    }

    public void init() {
        System.out.println("Start init-method");
    }

    public void destroy() {
        System.out.println("Start destroy-method");
    }
}

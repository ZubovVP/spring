package ru.zubov.lifecycle.annotation;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 08.08.2021.
 */
public class PersonForFactoryMethod {
    private PersonForFactoryMethod() {
    }

    public static PersonForFactoryMethod createPerson() {
        System.out.println("Create Person");
        return new PersonForFactoryMethod();
    }
}

package ru.zubov.lifecycle.xml;


/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 07.08.2021.
 */
public class Person {
    public void init(){
        System.out.println("Start init-method");
    }

    public void destroy(){
        System.out.println("Start destroy-method");
    }
}

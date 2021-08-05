package ru.zubov.di.annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 05.08.2021.
 */
@Component
public class Parent {
    @Value("${parent.name}")
    private String name;
    private int age;
    private final Child child;

    public Parent(@Qualifier("child1") Child child) {
        this.child = child;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Child getChild() {
        return child;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", child=" + child +
                '}';
    }
}

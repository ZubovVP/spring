package ru.zubov.di.annotation;

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
public class Child {
    private String name;

    public Child(@Value("${child.name}") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                '}';
    }
}

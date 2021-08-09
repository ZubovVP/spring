package ru.zubov.scope.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 09.08.2021.
 */
@Component
@Scope("prototype")
public class PersonPrototype {
    private String name = "Alex";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

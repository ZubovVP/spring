package ru.zubov.lifecycle.annotation;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 07.08.2021.
 */
@Component
public class Person {
    @PostConstruct
    public void init(){
        System.out.println("Start init-method");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Start destroy-method");
    }
}

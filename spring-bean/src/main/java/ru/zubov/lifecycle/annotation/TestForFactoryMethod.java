package ru.zubov.lifecycle.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 08.08.2021.
 */
@Configuration
public class TestForFactoryMethod {
    @Bean
    public PersonForFactoryMethod createPerson(){
        return PersonForFactoryMethod.createPerson();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestForFactoryMethod.class);
        PersonForFactoryMethod person = context.getBean(PersonForFactoryMethod.class);
        context.close();
    }
}

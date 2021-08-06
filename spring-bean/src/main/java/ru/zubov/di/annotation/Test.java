package ru.zubov.di.annotation;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 02.08.2021.
 */
@Configuration
@ComponentScan("ru.zubov.di.annotation")
@PropertySource("classpath:/application.properties")
public class Test {

    @Bean("child_1")
    public Child createChild_1(){
        return new Child("Duke");
    }
    @Bean("child_2")
    public Child createChild_2(){
        return new Child("Alex");
    }


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
        Parent parent = context.getBean(Parent.class);
    }
}

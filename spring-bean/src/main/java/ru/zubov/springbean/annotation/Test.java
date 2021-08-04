package ru.zubov.springbean.annotation;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.zubov.springbean.Action;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 02.08.2021.
 */
@Configuration
@ComponentScan("ru.zubov.springbean.annotation")
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
        Action hello = context.getBean("helloAnnotation", HelloWorld.class);
        hello.action();
    }
}

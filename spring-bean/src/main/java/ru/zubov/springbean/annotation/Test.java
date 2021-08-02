package ru.zubov.springbean.annotation;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.zubov.springbean.Action;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 02.08.2021.
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "app-context-annotation.xml"
        );

        Action hello = context.getBean("hello", HelloWorld.class);
        hello.action();
    }

}

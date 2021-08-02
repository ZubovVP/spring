package ru.zubov.springbean.annotation;

import org.springframework.stereotype.Component;
import ru.zubov.springbean.Action;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 02.08.2021.
 */
@Component("hello")
public class HelloWorld implements Action {

    @Override
    public void action() {
        System.out.println("Hello word! (annotation)");
    }
}

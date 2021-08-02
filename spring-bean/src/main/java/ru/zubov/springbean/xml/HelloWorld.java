package ru.zubov.springbean.xml;

import ru.zubov.springbean.Action;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 02.08.2021.
 */
public class HelloWorld implements Action {

    @Override
    public void action() {
        System.out.println("Hello word! (xml)");

    }
}

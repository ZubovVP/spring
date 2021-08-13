package ru.zubov.advice.before.simpleExampe;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 13.08.2021.
 */
public class TestBeforeAdvice {
    public static void main(String[] args) {
        ProxyFactory px = new ProxyFactory();
        px.setTarget(new WriterMessages());
        px.addAdvice(new SimpleBeforeAdvice());

        WriterMessages wm = (WriterMessages) px.getProxy();
        wm.write("Hello world!");
    }

}

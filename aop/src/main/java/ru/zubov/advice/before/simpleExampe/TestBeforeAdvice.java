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
        px.setTarget(new WriterMessage());
        px.addAdvice(new SimpleBeforeAdvice());
        WriterMessage wm = (WriterMessage) px.getProxy();
        wm.write("Hello world!");
    }
}

package ru.zubov.advice.afterreturning;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 17.08.2021.
 */
public class TestAfterReturning {
    public static void main(String[] args) {
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(new WriterMessage());
        pf.addAdvice(new SimpleAfterReturningAdvice());
        WriterMessage wm = (WriterMessage) pf.getProxy();
        wm.write("Hello world!");
    }
}

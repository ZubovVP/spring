package ru.zubov.advice.throws_advice;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 19.08.2021.
 */
public class TestThrowsAdvice {
    public static void main(String[] args) {
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleThrowsAdvice());
        pf.setTarget(new Error());
        Error er = (Error) pf.getProxy();
        try {
            er.doSomethingMethod();
        } catch (Exception ignored) {
        }
        try {
            er.doAnotherSomethingMethod();
        } catch (Exception ignored) {
        }
    }
}

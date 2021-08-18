package ru.zubov.advice.afterreturning;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 17.08.2021.
 */
public class TestCheckNumberAdvice {
    public static void main(String[] args) {
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new CheckNumberAdvice());
        pf.setTarget(new NumberGenerator());
        NumberGenerator ng = (NumberGenerator) pf.getProxy();
        for (int x = 0; x < 10; x++) {
            try {
                 ng.getNumber();
            } catch (SecurityException ex) {
                System.out.println("Number is wrong!");
            }
        }
    }
}

package ru.zubov.advice.throws_advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 19.08.2021.
 */
public class SimpleThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Exception ex) throws Throwable{
        System.out.println("***");
        System.out.println("Generic Exception ");
        System.out.println("Caught: " + ex.getClass().getName());
        System.out.println("***\n");
    }

    public void afterThrowing(Method method, Object[] args, Object target, IllegalArgumentException ex) throws Throwable {
        System.out.println("***");
        System.out.println("IllegalArgumentException Exception ");
        System.out.println("Caught: " + ex.getClass().getName());
        System.out.println("***\n");

    }
}

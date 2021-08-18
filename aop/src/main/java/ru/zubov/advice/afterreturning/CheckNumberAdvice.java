package ru.zubov.advice.afterreturning;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 17.08.2021.
 */
public class CheckNumberAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        if ((o1 instanceof NumberGenerator) && ("getNumber".equals(method.getName()))) {
            if ((Integer) o > 5) {
                System.out.println("Number is OK - " + o);
            } else {
                throw new SecurityException("Number is wrong!");
            }
        }
    }
}

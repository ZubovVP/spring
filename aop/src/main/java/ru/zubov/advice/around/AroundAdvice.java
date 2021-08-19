package ru.zubov.advice.around;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 18.08.2021.
 */
public class AroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Start around advice");
        Object retVal = (int) methodInvocation.proceed() * 2;
        System.out.println("Finish around advice ");
        return retVal;
    }
}

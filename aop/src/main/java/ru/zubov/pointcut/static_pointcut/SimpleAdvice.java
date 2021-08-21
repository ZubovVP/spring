package ru.zubov.pointcut.static_pointcut;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 21.08.2021.
 */
public class SimpleAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Before method " + methodInvocation.getMethod().getName());
        Object result = methodInvocation.proceed();
        System.out.println("After method " + methodInvocation.getMethod().getName());
        return result;
    }
}

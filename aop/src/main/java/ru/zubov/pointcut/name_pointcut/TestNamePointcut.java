package ru.zubov.pointcut.name_pointcut;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 22.08.2021.
 */
public class TestNamePointcut {
    public static void main(String[] args) {
        BeanFirst bf = new BeanFirst();
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.addMethodName("testOne");
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(bf);
        pf.addAdvisor(advisor);

        BeanFirst proxy = (BeanFirst) pf.getProxy();
        proxy.testOne();
        System.out.println("---------------");
        proxy.testTwo();
        System.out.println("---------------");
        proxy.testOne(10);
    }

}

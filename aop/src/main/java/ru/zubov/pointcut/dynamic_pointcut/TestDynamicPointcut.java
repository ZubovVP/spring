package ru.zubov.pointcut.dynamic_pointcut;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 21.08.2021.
 */
public class TestDynamicPointcut {
    public static void main(String[] args) {
        BeanFirst bf = new BeanFirst();

        Pointcut pc = new SimpleDynamicPointcut();
        Advice advice = new SimpleAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pc, advice);

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(bf);
        BeanFirst beanProxyFirst = (BeanFirst) pf.getProxy();

        beanProxyFirst.doSomethingOne(1);
        beanProxyFirst.doSomethingOne(10);
        beanProxyFirst.doSomethingOne(100);

        beanProxyFirst.doSomethingTwo(100);

    }
}

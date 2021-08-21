package ru.zubov.pointcut.static_pointcut;

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
public class TestStaticPointcut {
    public static void main(String[] args) {
        BeanFirst bf = new BeanFirst();
        BeanSecond bs = new BeanSecond();

        Pointcut pc = new SimpleStaticPointcut();
        Advice advice = new SimpleAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pc, advice);

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(bf);
        BeanFirst beanProxyFirst = (BeanFirst) pf.getProxy();

        pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(bs);
        BeanSecond beanProxySecond = (BeanSecond) pf.getProxy();

        beanProxyFirst.doSomethingOne();
        beanProxyFirst.doSomethingTwo();
        System.out.println("---------------------");
        beanProxySecond.doSomethingOne();
        beanProxySecond.doSomethingTwo();
    }
}

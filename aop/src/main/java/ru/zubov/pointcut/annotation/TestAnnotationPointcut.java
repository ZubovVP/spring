package ru.zubov.pointcut.annotation;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 22.08.2021.
 */
public class TestAnnotationPointcut {
    public static void main(String[] args) {
        Bean bean = new Bean();
        AnnotationMatchingPointcut pc = AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);
        Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(bean);
        Bean proxy = (Bean) pf.getProxy();
        proxy.doSomethingOne();
        System.out.println("----------------");
        proxy.doSomethingTwo(100);
    }
}

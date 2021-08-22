package ru.zubov.pointcut.aspectj;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 22.08.2021.
 */
public class TestAspectJPointcut {
    public static void main(String[] args) {
        BeanFirst bf = new BeanFirst();
        AspectJExpressionPointcut pc = new AspectJExpressionPointcut();
        pc.setExpression("execution(* do*(..))");
        Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(bf);
        pf.addAdvisor(advisor);

        BeanFirst proxy = (BeanFirst) pf.getProxy();
        proxy.doSomethingOne();
        System.out.println("------------");
        proxy.doSomethingTwo(100);
        System.out.println("------------");
        proxy.somethingThree();
    }
}

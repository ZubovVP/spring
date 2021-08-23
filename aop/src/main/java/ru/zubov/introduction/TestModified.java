package ru.zubov.introduction;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 24.08.2021.
 */
public class TestModified {
    public static void main(String[] args) {
        Person person = new Person("Duke", "Smith", 29);
        IntroductionAdvisor advisor = new IsModifiedAdvisor();
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(person);
        pf.addAdvisor(advisor);
        pf.setOptimize(true);

        Person proxy = (Person) pf.getProxy();
        IsModified proxyInterface = (IsModified) proxy;
        System.out.println("Is Person?  " + (proxy instanceof Person));
        System.out.println("Is IsModified?  " + (proxy instanceof IsModified));
        System.out.println("Has been modified? " +  proxyInterface.isModified());
        proxy.setName("Duke");
        System.out.println("Has been modified? " +  proxyInterface.isModified());
        proxy.setName("Alex");
        System.out.println("Has been modified? " +  proxyInterface.isModified());
    }

}

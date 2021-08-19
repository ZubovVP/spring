package ru.zubov.advice.around;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 18.08.2021.
 */
public class TestAroundAdvice {

    public static void main(String[] args) {
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(new WriterMessages());
        pf.addAdvice(new AroundAdvice());
        WriterMessages wm = (WriterMessages) pf.getProxy();
        int result = wm.write(5);
        System.out.println("count after advice - " + result);
    }
}

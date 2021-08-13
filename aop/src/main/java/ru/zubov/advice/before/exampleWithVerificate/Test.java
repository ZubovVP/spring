package ru.zubov.advice.before.exampleWithVerificate;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 13.08.2021.
 */
public class Test {
    private static WriterMessages WM;

    public static void main(String[] args) {
        checkWithCorrectNameAndPassword();
        try {
            checkWithIncorrectNameAndPassword();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        try {
            checkWithNameAndPasswordAreNull();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    private static void checkWithCorrectNameAndPassword() {
        WM = getWriter("Duke", "psw");
        WM.write("Hello world!");
    }

    private static void checkWithIncorrectNameAndPassword() {
        WM = getWriter("Alex", "psw");
        WM.write("Hello world!");
    }

    private static void checkWithNameAndPasswordAreNull() {
        WM = getWriter(null, null);
        WM.write("Hello world!");
    }

    private static WriterMessages getWriter(String name, String psw) {
        WriterMessages writerMessages = new WriterMessages();
        SecurityManager smg = new SecurityManager();
        smg.login(name, psw);
        SecurityAdvice advice = new SecurityAdvice(smg);
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(writerMessages);
        pf.addAdvice(advice);
        return (WriterMessages) pf.getProxy();
    }
}

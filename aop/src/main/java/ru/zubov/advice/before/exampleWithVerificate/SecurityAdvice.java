package ru.zubov.advice.before.exampleWithVerificate;

import lombok.AllArgsConstructor;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 13.08.2021.
 */
@AllArgsConstructor
public class SecurityAdvice implements MethodBeforeAdvice {
    private final SecurityManager sm;

    @Override
    public void before(Method method, Object[] objects, Object o) {
        User user = this.sm.getLoginAndPassword();
        if (user.getLogin() == null || user.getPsw() == null) {
            throw new SecurityException("Don't fill in login and password");
        }
        if (!user.getLogin().equals("Duke") || !user.getPsw().equals("psw")) {
            throw new SecurityException("Incorrect login or password!");
        }
        System.out.println("Everything is OK!");
    }
}

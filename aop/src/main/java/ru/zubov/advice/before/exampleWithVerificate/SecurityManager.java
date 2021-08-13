package ru.zubov.advice.before.exampleWithVerificate;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 13.08.2021.
 */
public class SecurityManager {
    private static ThreadLocal<User> user = new ThreadLocal<>();

    public void login(String name, String psw) {
        user.set(new User(name, psw));
    }

    public void logout() {
        user.set(null);
    }

    public User getLoginAndPassword(){
        return user.get();
    }
}

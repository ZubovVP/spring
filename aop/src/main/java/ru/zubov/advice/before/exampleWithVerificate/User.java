package ru.zubov.advice.before.exampleWithVerificate;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 13.08.2021.
 */
public class User {
    private String login;
    private String psw;

    public User(String login, String psw) {
        this.login = login;
        this.psw = psw;
    }

    public String getLogin() {
        return login;
    }

    public String getPsw() {
        return psw;
    }
}

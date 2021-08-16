package ru.zubov.advice.before.exampleWithVerificate;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 13.08.2021.
 */
@Data
@AllArgsConstructor
public class User {
    private String login;
    private String psw;
}

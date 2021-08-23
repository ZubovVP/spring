package ru.zubov.introduction;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 24.08.2021.
 */
@Data
@AllArgsConstructor
public class Person {
    private String name;
    private String surname;
    private int age;
}

package ru.zubov.advice.afterreturning;

import java.util.Random;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 17.08.2021.
 */
public class NumberGenerator {
    private static final Random RD = new Random();

    public int getNumber() {
        return RD.nextInt(10);
    }
}

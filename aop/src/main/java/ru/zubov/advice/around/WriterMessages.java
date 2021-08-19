package ru.zubov.advice.around;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 13.08.2021.
 */
public class WriterMessages {

    public int write(int count) {
        System.out.println("Count = " + count);
        return count;
    }
}

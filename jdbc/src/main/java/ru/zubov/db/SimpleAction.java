package ru.zubov.db;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 27.08.2021.
 */
public interface SimpleAction<E> {
    void add(E element);

    E update(E element);

    void delete(int id);
}

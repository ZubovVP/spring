package ru.zubov.advice.throws_advice;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 19.08.2021.
 */
public class Error {

    public void doSomethingMethod() throws Exception {
        throw new Exception("doSomethingMethod");
    }

    public void doAnotherSomethingMethod() throws IllegalArgumentException {
        throw new IllegalArgumentException("doAnotherSomethingMethod");
    }

}

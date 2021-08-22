package ru.zubov.pointcut.name_pointcut;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 22.08.2021.
 */
public class BeanFirst {

    public void testOne() {
        System.out.println("Processing method - testOne without arguments");
    }

    public int testOne(int count) {
        System.out.println("Processing method - testOne with arguments");
        return count;
    }

    public void testTwo() {
        System.out.println("Processing method - testTwo without arguments");
    }
}

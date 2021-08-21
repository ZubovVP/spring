package ru.zubov.pointcut.dynamic_pointcut;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 21.08.2021.
 */
public class BeanFirst {

    public void doSomethingOne(int x){
        System.out.println("BeanFirst: starting method doSomethingOne, count = " + x);
    }

    public void doSomethingTwo(int x){
        System.out.println("BeanFirst: starting method doSomethingTwo, count = " + x);
    }

}

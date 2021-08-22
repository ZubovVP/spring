package ru.zubov.pointcut.aspectj;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 21.08.2021.
 */
public class BeanFirst {

    public void doSomethingOne(){
        System.out.println("BeanFirst: starting method doSomethingOne");
    }

    public int doSomethingTwo(int count){
        System.out.println("BeanFirst: starting method doSomethingTwo");
        return count;
    }

    public void somethingThree(){
        System.out.println("BeanFirst: starting method somethingThree");
    }
}

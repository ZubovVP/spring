package ru.zubov.pointcut.annotation;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 22.08.2021.
 */
public class Bean {
    @AdviceRequired
    public void doSomethingOne(){
        System.out.println("BeanFirst: starting method doSomethingOne");
    }

    public int doSomethingTwo(int count){
        System.out.println("BeanFirst: starting method doSomethingTwo");
        return count;
    }
}

package ru.zubov.introduction;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 23.08.2021.
 */
public class IsModifiedPerson extends DelegatingIntroductionInterceptor implements IsModified {
    private boolean isModified = false;
    private Map<Method, Method> methods = new HashMap<Method, Method>();


    @Override
    public boolean isModified() {
        return this.isModified;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        if (!this.isModified) {
            if ((mi.getMethod().getName().startsWith("set")) && (mi.getArguments().length == 1)) {
                Method getter = getGetter(mi.getMethod());
                if (getter != null) {
                    Object newValue = mi.getArguments()[0];
                    Object oldValue = getter.invoke(mi.getThis(), null);

                    if ((newValue == null) && (oldValue == null)) {
                        this.isModified = false;
                    } else if ((newValue == null) && (oldValue != null)) {
                        this.isModified = true;
                    } else if ((newValue != null) && (oldValue == null)) {
                        this.isModified = true;
                    } else {
                        this.isModified = (!newValue.equals(oldValue));
                    }
                }
            }
        }
        return super.invoke(mi);
    }

    private Method getGetter(Method setter) {
        Method getter = null;

        getter = this.methods.get(setter);

        if (getter != null) {
            return getter;
        }

        String getterName = setter.getName().replaceFirst("set", "get");
        try {
            getter = setter.getDeclaringClass().getMethod(getterName, null);
            synchronized (this.methods) {
                this.methods.put(setter, getter);
            }
            return getter;
        } catch (NoSuchMethodException e) {
            return null;
        }
    }
}

package com.epam.lab.task6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MyClass myClass = new MyClass();
        Method method = MyClass.class.getMethod("myMethod", String[].class);
        method.invoke(myClass, (Object) new String[]{"cat", "dog", "rat"});
        method = MyClass.class.getMethod("myMethod", String.class, int[].class);
        method.invoke(myClass, "cat", new int[]{4, 8, 6});
    }
}
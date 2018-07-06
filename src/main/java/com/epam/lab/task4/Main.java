package com.epam.lab.task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    private static final Logger LOG = LogManager.getLogger("com.epam.lab");

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> c = Figure.class;
        Figure figure = new Figure("Rectangle");

        Method method = c.getMethod("getFigureType");
        LOG.info("Figure type: " + method.invoke(figure));

        method = c.getDeclaredMethod("calculateRectangleArea", int.class, int.class);
        method.setAccessible(true);
        method.invoke(figure, 4, 5);

        method = c.getDeclaredMethod("calculateSquareArea", int.class);
        method.setAccessible(true);
        LOG.info("Square area: " + method.invoke(figure, 6));
    }
}
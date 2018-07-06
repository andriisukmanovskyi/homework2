package com.epam.lab.task2_3;

import com.epam.lab.task2_3.model.Triangle;
import com.epam.lab.task2_3.my.annotation.MyAnnotation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    private static final Logger LOG = LogManager.getLogger("com.epam.lab");
    private static final Class<MyAnnotation> myAnnotationClass = MyAnnotation.class;

    public static void main(String[] args) {
        Class<?> c = Triangle.class;
        Field[] fields = c.getDeclaredFields();
        Arrays.stream(fields).filter(f -> isFieldMyAnnotated.test(f)).
                forEach(f -> LOG.info(f + "\nvalue = " + getAnnotationValue.apply(f)));
    }

    private static Predicate<Field> isFieldMyAnnotated = field -> Objects.nonNull(field.getAnnotation(myAnnotationClass));

    private static Function<Field, Integer> getAnnotationValue = field -> field.getAnnotation(myAnnotationClass).value();
}
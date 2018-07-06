package com.epam.lab.task5.service;

import com.epam.lab.task5.classhelper.ClassHelper;
import com.epam.lab.task5.model.Person;

import java.lang.reflect.Field;

public class ValueSetterService {

    public static <T> void setValue(Person person, T inputVar) throws IllegalAccessException, NoSuchFieldException {
        String inputVarType = getInputVarType(inputVar);
        Field[] fields = Person.class.getDeclaredFields();
        for (Field field : fields) {
            if (isCorrectType(field, inputVarType)) {
                field.set(person, inputVar);
            }
        }
    }

    private static <T> String getInputVarType(T inputVar) throws IllegalAccessException, NoSuchFieldException {
        ClassHelper classHelper = new ClassHelper(inputVar);
        Field field = classHelper.getClass().getDeclaredField("someVar");
        field.setAccessible(true);
        return field.get(classHelper).getClass().getSimpleName().toLowerCase();
    }

    private static boolean isCorrectType(Field field, String inputVarType){
        field.setAccessible(true);
        return inputVarType.contains(field.getType().getSimpleName().toLowerCase());
    }
}
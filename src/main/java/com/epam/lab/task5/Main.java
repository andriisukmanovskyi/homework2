package com.epam.lab.task5;

import com.epam.lab.task5.model.Person;
import com.epam.lab.task5.model.Pet;
import com.epam.lab.task5.service.ValueSetterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOG = LogManager.getLogger("com.epam.lab");

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Person person = new Person("ivan", 35, 1.80);
        LOG.info(person.toString());
        String name = "petro";
        int age = 48;
        double height = 48;
        Pet pet = new Pet("sherhan", 2);
        ValueSetterService.setValue(person, pet);
        LOG.info(person.toString());
    }
}
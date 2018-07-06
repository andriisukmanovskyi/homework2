package com.epam.lab.task6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyClass {
    private static final Logger LOG = LogManager.getLogger("com.epam.lab");

    public void myMethod(String a, int... args) {
        LOG.info("First parameter: " + a);
        LOG.info("Other parameters: ");
        for (int i : args) {
            LOG.info("\t" + i);
        }
    }

    public void myMethod(String... args) {
        LOG.info("All parameters: ");
        for (String str : args) {
            LOG.info("\t" + str);
        }
    }
}
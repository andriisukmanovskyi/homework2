package com.epam.lab.task7.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.*;
import java.util.Arrays;

public class ClassInfoService {
    private static final Logger LOG = LogManager.getLogger("com.epam.lab");

    private Class<?> c;

    public ClassInfoService(Class<?> c) {
        this.c = c;
    }

    public void showClassInfo() {
        showClassHeaderInfo();
        showClassFields();
        showClassConstructors();
        showClassMethods();
    }

    private void showClassHeaderInfo() {
        LOG.info("Package:\n" + c.getPackage().getName() + "\n");
        showAnnotations(c);
        LOG.info("\nClass modifiers:\n" + Modifier.toString(c.getModifiers()) +
                "\n\nClass name:\n" + c.getSimpleName());
        showClassTypeParameters();
        LOG.info("\nSuperclass:\n" + c.getSuperclass().getCanonicalName());
        showClassImplementedInterfaces();
        showClassClasses();
    }

    private void showClassImplementedInterfaces() {
        if (c.getInterfaces().length > 0) {
            LOG.info("\nImplemented interfaces:");
            Arrays.stream(c.getInterfaces()).forEach(LOG::info);
        }
    }

    private void showClassTypeParameters() {
        if (c.getTypeParameters().length > 0) {
            LOG.info("\nType parameters:");
            Arrays.stream(c.getTypeParameters()).forEach(LOG::info);
        }
    }

    private void showClassFields() {
        LOG.info("\nClass fields: ");
        for (Field field : c.getDeclaredFields()) {
            showAnnotations(field);
            LOG.info(field);
        }
    }

    private void showClassConstructors() {
        LOG.info("\nClass constructors: ");
        for (Constructor constructor : c.getDeclaredConstructors()) {
            showAnnotations(constructor);
            LOG.info(constructor);
        }
    }

    private void showClassMethods() {
        LOG.info("\nClass methods: ");
        for (Method method : c.getDeclaredMethods()) {
            showAnnotations(method);
            LOG.info(method);
        }
    }

    private void showClassClasses() {
        LOG.info("\nInner classes, interfaces, enums: ");
        for (Class c : c.getDeclaredClasses()) {
            showAnnotations(c);
            LOG.info(c.getCanonicalName());
        }
    }

    private void showAnnotations(AnnotatedElement annotatedElement) {
        if (annotatedElement.getAnnotations().length > 0)
            LOG.info("Annotations:");
        Arrays.stream(annotatedElement.getAnnotations()).forEach(LOG::info);
    }
}
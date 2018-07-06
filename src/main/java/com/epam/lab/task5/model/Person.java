package com.epam.lab.task5.model;

public class Person {

    private String name;
    private int age;
    private double height;
    Pet pet;

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.pet = new Pet("dog", 222);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", person=" + pet.toString() +
                '}';
    }
}
package com.epam.lab.task7.model;

import com.epam.lab.task2_3.my.annotation.MyAnnotation;

@Deprecated
public class Ship<T> {

    private static final int FULL_SHIP_HEALTH = 300;

    @MyAnnotation
    private int shipHealth;
    private T droid;

    public Ship(T droid) {
        this.shipHealth = FULL_SHIP_HEALTH;
        this.droid = droid;
    }

    @Deprecated
    private Ship(int shipHealth) {
    }

    public int getShipHealth() {
        return shipHealth;
    }

    public void setShipHealth(int shipHealth) {
        this.shipHealth = shipHealth;
        if (this.shipHealth > FULL_SHIP_HEALTH)
            this.shipHealth = FULL_SHIP_HEALTH;
    }

    public T getDroid() {
        return droid;
    }

    public void setDroids(T droid) {
        this.droid = droid;
    }
}
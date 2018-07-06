package com.epam.lab.task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Figure {

    private static final Logger LOG = LogManager.getLogger("com.epam.lab");

    private String type;
    private int square;

    public Figure(String type) {
        this.type = type;
    }

    public String getFigureType() {
        return this.type;
    }

    private void calculateRectangleArea(int sideA, int sideB) {
        LOG.info("Rectangle area: " + (this.square = sideA * sideB));
    }

    private int calculateSquareArea(int side) {
        return side * side;
    }
}
package com.epam.lab.task7;

import com.epam.lab.task7.model.Ship;
import com.epam.lab.task7.service.ClassInfoService;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String droid = "droid";
        Ship<String> ship = new Ship<>(droid);
        ClassInfoService classInfoService = new ClassInfoService(ship.getDroid().getClass()); // info about incoming object
//        ClassInfoService classInfoService = new ClassInfoService(Class.forName("com.epam.lab.task7.model.Ship"));
        classInfoService.showClassInfo();
    }
}
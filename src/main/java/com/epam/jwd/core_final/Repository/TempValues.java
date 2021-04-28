package com.epam.jwd.core_final.Repository;

import com.epam.jwd.core_final.domain.Planet;
import com.epam.jwd.core_final.domain.Spaceship;

import java.time.LocalDate;

public enum TempValues {
    GENERAL;
    private static String from;
    private static LocalDate currentDate;
    private static String to;
    private static Planet toP;
    private static Planet fromP;
    private static Spaceship spaceship;
    private static int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        TempValues.id = id;
    }

    public  LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        TempValues.currentDate = currentDate;
    }

    public Planet getToP() {
        return toP;
    }

    public void setToP(Planet toP) {
        TempValues.toP = toP;
    }

    public Planet getFromP() {
        return fromP;
    }

    public void setFromP(Planet fromP) {
        TempValues.fromP = fromP;
    }

    public Spaceship getSpaceship() {
        return spaceship;
    }

    public void setSpaceship(Spaceship spaceship) {
        TempValues.spaceship = spaceship;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        TempValues.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String name) {
        TempValues.from = name;
    }
}

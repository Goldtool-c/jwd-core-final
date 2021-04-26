package com.epam.jwd.core_final.Repository;

import com.epam.jwd.core_final.domain.FlightMission;
import com.epam.jwd.core_final.domain.Planet;
import com.epam.jwd.core_final.domain.Spaceship;

public enum PlanetTemp {
    GENERAL;
    private static String from;
    private static String to;
    private static Planet toP;
    private static Planet fromP;
    private static Spaceship spaceship;

    public Planet getToP() {
        return toP;
    }

    public void setToP(Planet toP) {
        PlanetTemp.toP = toP;
    }

    public Planet getFromP() {
        return fromP;
    }

    public void setFromP(Planet fromP) {
        PlanetTemp.fromP = fromP;
    }

    public Spaceship getSpaceship() {
        return spaceship;
    }

    public void setSpaceship(Spaceship spaceship) {
        PlanetTemp.spaceship = spaceship;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        PlanetTemp.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String name) {
        PlanetTemp.from = name;
    }
}

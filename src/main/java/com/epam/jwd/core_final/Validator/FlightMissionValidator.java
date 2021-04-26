package com.epam.jwd.core_final.Validator;

import com.epam.jwd.core_final.domain.Planet;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.exception.InValidPlanetException;
import com.epam.jwd.core_final.exception.InValidSpaceshipException;

public enum FlightMissionValidator {
    GENERAL;
    private boolean SpaceshipValid(Spaceship spaceship, Double distance) throws InValidSpaceshipException {
        boolean flag = true;
        if(spaceship.getFlightDistance()<distance)
        {
            throw new InValidSpaceshipException("Invalid distance value");
        }
        if(!spaceship.getReady())
        {
            throw new InValidSpaceshipException("Invalid ready state");
        }
        return true;
    }
    private boolean PlanetsValid(Planet from, Planet to) throws InValidPlanetException {
        if(from.equals(to))
        {
            throw new InValidPlanetException("(Planet) from should not be equal to (Planet) to");
        }
        return true;
    }
    public boolean valid(Spaceship spaceship, Double distance, Planet from, Planet to) throws InValidPlanetException, InValidSpaceshipException {
        if(this.PlanetsValid(from, to)&&this.SpaceshipValid(spaceship, distance))
        {
            return true;
        }
        return false;
    }
}

package com.epam.jwd.core_final.Repository;

import com.epam.jwd.core_final.domain.AbstractBaseEntity;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Planet;
import com.epam.jwd.core_final.domain.Spaceship;

import java.util.ArrayList;

public enum BaseEntityStorage {
    GENERAL;
    private static ArrayList<CrewMember> crewStorage;
    private static ArrayList<Spaceship> shipStorage;
    private static ArrayList<Planet> planetStorage;
    public ArrayList<Planet> getPlanetStorage() {
        return planetStorage;
    }
    public void setPlanetStorage(ArrayList<Planet> planetStorage) {
        BaseEntityStorage.planetStorage = planetStorage;
    }
    public void setCrewStorage(ArrayList<CrewMember> crewStorage) {
        BaseEntityStorage.crewStorage = crewStorage;
    }
    public ArrayList<CrewMember> getCrewStorage()
    {
        return crewStorage;
    }
    public void setShipStorage(ArrayList<Spaceship> shipStorage) {
        BaseEntityStorage.shipStorage = shipStorage;
    }
    public ArrayList<Spaceship> getShipStorage()
    {
        return shipStorage;
    }
}

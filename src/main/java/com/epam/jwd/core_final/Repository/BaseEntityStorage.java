package com.epam.jwd.core_final.Repository;

import com.epam.jwd.core_final.domain.*;

import java.util.ArrayList;

public enum BaseEntityStorage {
    GENERAL;
    private static ArrayList<CrewMember> crewStorage;
    private static ArrayList<Spaceship> shipStorage;
    private static ArrayList<Planet> planetStorage;
    private static ArrayList<FlightMission> flightMission = new ArrayList<>();
    public ArrayList<Planet> getPlanetStorage() {
        return planetStorage;
    }

    public ArrayList<FlightMission> getFlightMission() { return flightMission; }
    public void setFlightMission(ArrayList<FlightMission> flightMission) { BaseEntityStorage.flightMission = flightMission; }
    public void addMission(FlightMission flightMission) { BaseEntityStorage.flightMission.add(flightMission); }
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

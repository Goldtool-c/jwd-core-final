package com.epam.jwd.core_final.Repository;

import com.epam.jwd.core_final.domain.AbstractBaseEntity;
import com.epam.jwd.core_final.domain.CrewMember;

import java.util.ArrayList;

public enum BaseEntityStorage {
    GENERAL;
    private static ArrayList<AbstractBaseEntity> crewStorage;
    private static ArrayList<AbstractBaseEntity> shipStorage;

    public void setCrewStorage(ArrayList<AbstractBaseEntity> crewStorage) {
        BaseEntityStorage.crewStorage = crewStorage;
    }
    public ArrayList<AbstractBaseEntity> getCrewStorage()
    {
        return crewStorage;
    }

    public void setShipStorage(ArrayList<AbstractBaseEntity> shipStorage) {
        BaseEntityStorage.shipStorage = shipStorage;
    }

    public ArrayList<AbstractBaseEntity> getShipStorage()
    {
        return shipStorage;
    }
}

package com.epam.jwd.core_final.Repository;

import com.epam.jwd.core_final.domain.AbstractBaseEntity;
import com.epam.jwd.core_final.domain.CrewMember;

import java.util.ArrayList;

public enum BaseEntityStorage {
    GENERAL;
    private static ArrayList<AbstractBaseEntity> crewStorage;

    public void setCrewStorage(ArrayList<AbstractBaseEntity> crewStorage) {
        BaseEntityStorage.crewStorage = crewStorage;
    }
    public ArrayList<AbstractBaseEntity> getCrewStorage()
    {
        return crewStorage;
    }
}

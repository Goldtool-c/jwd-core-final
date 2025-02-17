package com.epam.jwd.core_final.context.impl;

import com.epam.jwd.core_final.Repository.BaseEntityStorage;
import com.epam.jwd.core_final.context.ApplicationContext;
import com.epam.jwd.core_final.converter.ConverterStringToCrewMember;
import com.epam.jwd.core_final.domain.BaseEntity;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Planet;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.exception.InvalidStateException;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

// todo
public class NassaContext implements ApplicationContext {

    private Collection<CrewMember> crewMembers = new ArrayList<>();
    private Collection<Spaceship> spaceships = new ArrayList<>();
    private Collection<Planet> planetMap = new ArrayList<>();

    @Override
    public <T extends BaseEntity> Collection<T> retrieveBaseEntityList(Class<T> tClass) {
        return null;
    }

    @Override
    public void init() throws InvalidStateException {
        File file = new File(".src\\main\\resources\\input\\crew");
        //System.out.println(fi);
        BaseEntityStorage.GENERAL.setCrewStorage(ConverterStringToCrewMember.GENERAL.convert(file));
        throw new InvalidStateException("hth");
    }
}

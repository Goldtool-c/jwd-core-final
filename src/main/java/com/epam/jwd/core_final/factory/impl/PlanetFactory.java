package com.epam.jwd.core_final.factory.impl;

import com.epam.jwd.core_final.domain.Planet;
import com.epam.jwd.core_final.factory.EntityFactory;

public enum PlanetFactory implements EntityFactory{
    GENERAL;
        @Override
        public Planet create(Object... args) {
            return new Planet((String) args[0],(int)args[1],(int) args[2]);
        }

}

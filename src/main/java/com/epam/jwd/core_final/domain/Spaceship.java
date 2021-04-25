package com.epam.jwd.core_final.domain;

import java.io.Serializable;
import java.util.Map;

/**
 * crew {@link java.util.Map<Role, Short>}
 * flightDistance {@link Long} - total available flight distance
 * isReadyForNextMissions {@link Boolean} - true by default. Set to false, after first failed mission
 */
public class Spaceship extends AbstractBaseEntity{
    private long flightDistance;
    private boolean isReadyForNextMissions = true;
    public short[] requires = new short[4];
    private Map<Role, Short> crew;
    public Spaceship(String name, long flightDistance, short[] requires)
    {
        this.name=name;
        this.flightDistance=flightDistance;
        System.arraycopy(requires, 0, this.requires, 0, requires.length);
    }

    public short[] getRequires() {
        return requires;
    }
    //todo
}

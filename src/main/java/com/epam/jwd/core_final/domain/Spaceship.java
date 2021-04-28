package com.epam.jwd.core_final.domain;

import com.epam.jwd.core_final.Repository.TempValues;

import java.util.Map;

public class Spaceship extends AbstractBaseEntity{
    private long flightDistance;
    private boolean isReadyForNextMissions = true;
    private short[] requires = new short[4];
    private Map<Role, Short> crew;
    public Spaceship(String name, long flightDistance, short[] requires)
    {
        int id= TempValues.GENERAL.getId()+1;
        this.id=Integer.parseInt("1"+id);
        TempValues.GENERAL.setId(id);
        this.name=name;
        this.flightDistance=flightDistance;
        System.arraycopy(requires, 0, this.requires, 0, requires.length);
    }

    public boolean getReady() {
        return isReadyForNextMissions;
    }
    public void setReadyForNextMissions(boolean r) {this.isReadyForNextMissions=r;}
    public long getFlightDistance()
    {
        return flightDistance;
    }
    public short[] getRequires() {
        return requires;
    }
    //todo
}

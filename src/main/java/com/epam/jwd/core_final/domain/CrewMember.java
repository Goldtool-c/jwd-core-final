package com.epam.jwd.core_final.domain;

import com.epam.jwd.core_final.Repository.TempValues;

public class CrewMember extends AbstractBaseEntity{
    private final Role role;
    private final Rank rank;
    private boolean ready=true;
    public CrewMember(String name, Role role, Rank rank)
    {
        int id= TempValues.GENERAL.getId()+1;
        this.id=Integer.parseInt("1"+id);
        TempValues.GENERAL.setId(id);
        this.name=name;
        this.role=role;
        this.rank=rank;
    }
    public void setReady(boolean ready) {
        this.ready = ready;
    }
    public String getRole()
    {
        switch (role)
        {
            case PILOT: return "Pilot";
            case COMMANDER: return "Commander";
            case FLIGHT_ENGINEER: return "Flight engineer";
            case MISSION_SPECIALIST: return "Mission specialist";
            default: return "dummy";
        }
    }
    public Role getRole(int i)
    {
        return this.role;
    }
    public String getRank()
    {
        switch (rank)
        {
            case SECOND_OFFICER: return "Second officer";
            case FIRST_OFFICER: return "First officer";
            case TRAINEE: return "Trainee";
            case CAPTAIN: return "Captain";
            default: return "dummy";
        }
    }
    public boolean isReadyForNextMissions(){ return ready; }
    // todo
}

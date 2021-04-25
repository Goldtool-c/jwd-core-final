package com.epam.jwd.core_final.domain;

import java.io.Serializable;

/**
 * Expected fields:
 * <p>
 * role {@link Role} - member role
 * rank {@link Rank} - member rank
 * isReadyForNextMissions {@link Boolean} - true by default. Set to false, after first failed mission
 */
public class CrewMember extends AbstractBaseEntity implements Serializable {
    private final Role role;
    private final Rank rank;
    private boolean ready=true;
    public CrewMember(String name, Role role, Rank rank)
    {
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

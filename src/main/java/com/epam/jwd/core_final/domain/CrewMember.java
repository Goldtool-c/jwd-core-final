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
    public boolean isReadyForNextMissions(){ return ready; }
    // todo
}

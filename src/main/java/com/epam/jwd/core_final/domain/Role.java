package com.epam.jwd.core_final.domain;

import com.epam.jwd.core_final.exception.UnknownEntityException;

public enum Role implements BaseEntity {
    MISSION_SPECIALIST(1L),
    FLIGHT_ENGINEER(2L),
    PILOT(3L),
    COMMANDER(4L);

    private final Long id;

    Role(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        int id = Math.toIntExact(getId());
        switch (id)
        {
            case 1: { return "Mission_Specialist"; }
            case 2: { return "Flight_Engineer"; }
            case 3: { return "Pilot"; }
            case 4: { return "Commander"; }
            default:{ throw new UnknownEntityException("Id "+id+" does not exist");}
        }
    }

    public static Role resolveRoleById(int id) {
        switch (id)
        {
            case 1: { return Role.MISSION_SPECIALIST; }
            case 2: { return Role.FLIGHT_ENGINEER; }
            case 3: { return Role.PILOT; }
            case 4: { return Role.COMMANDER; }
            default:{throw new UnknownEntityException("Id "+id+" does not exist");}
        }
    }
}

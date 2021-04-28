package com.epam.jwd.core_final.domain;

import com.epam.jwd.core_final.exception.UnknownEntityException;

public enum Rank implements BaseEntity {
    TRAINEE(1L),
    SECOND_OFFICER(2L),
    FIRST_OFFICER(3L),
    CAPTAIN(4L);

    private final Long id;

    Rank(Long id) {
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
            case 1: { return "TRAINEE"; }
            case 2: { return "SECOND_OFFICER"; }
            case 3: { return "FIRST_OFFICER"; }
            case 4: { return "CAPTAIN"; }
            default:{ throw new UnknownEntityException("Id "+id+" does not exist");}
        }
    }

    public static Rank resolveRankById(int id) {

        switch (id)
        {
            case 1: { return Rank.TRAINEE; }
            case 2: { return Rank.SECOND_OFFICER; }
            case 3: { return Rank.FIRST_OFFICER; }
            case 4: { return Rank.CAPTAIN; }
            default:{ throw new UnknownEntityException("Id "+id+" does not exist");}
        }
    }
}

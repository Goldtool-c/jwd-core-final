package com.epam.jwd.core_final.domain;

import com.epam.jwd.core_final.Repository.BaseEntityStorage;
import com.epam.jwd.core_final.Validator.FlightMissionValidator;
import com.epam.jwd.core_final.exception.InValidPlanetException;
import com.epam.jwd.core_final.exception.InValidSpaceshipException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public enum SimpleMissionFabric {
    INSTANCE;
    public FlightMission create(Planet from, Planet to, Spaceship spaceship)
    {
        FlightMission flightMission = new FlightMission();
        flightMission.setFrom(from);
        flightMission.setTo(to);
        int k1,k2;
        double d;
        k1=(from.getX()-to.getX())*(from.getX()-to.getX());
        k2=(from.getY()-to.getY())*(from.getY()-to.getY());
        d=Math.sqrt(k1+k2);
        try {
            FlightMissionValidator.GENERAL.valid(spaceship,d,from,to);
        } catch (InValidPlanetException | InValidSpaceshipException e) {
            System.out.println(e.getMessage());
        }
        flightMission.setDistance(d);
        List<CrewMember> crew = new ArrayList<>();
        CrewMember temp;
        short requires[]=spaceship.getRequires();
        for (int j = 0; j < 4; j++) {
        for (int i = 0; i < requires[j]; i++) {
            temp=BaseEntityStorage.GENERAL.getCrewStorage().get(i);
            if(temp.isReadyForNextMissions())
            {
                if(temp.getRole(1).equals(Role.resolveRoleById(j+1)))
                {
                    crew.add(temp);
                    temp.setReady(false);
                }
            }
        }
        }
        return flightMission;
    }
}

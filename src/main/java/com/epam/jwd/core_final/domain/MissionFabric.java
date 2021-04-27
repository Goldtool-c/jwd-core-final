package com.epam.jwd.core_final.domain;

import com.epam.jwd.core_final.Repository.BaseEntityStorage;
import com.epam.jwd.core_final.Validator.FlightMissionValidator;
import com.epam.jwd.core_final.exception.InValidPlanetException;
import com.epam.jwd.core_final.exception.InValidSpaceshipException;
import com.epam.jwd.core_final.util.DateOperations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public enum MissionFabric {
    INSTANCE;
    public FlightMission create(Planet from, Planet to, Spaceship spaceship, String date)
    {
        FlightMission flightMission = new FlightMission();
        flightMission.setFrom(from);
        flightMission.setTo(to);
        int[] dateInt = DateOperations.GENERAL.StringToDate(date);
        LocalDate dateStart = LocalDate.of(dateInt[2], dateInt[1], dateInt[0]);
        LocalDate dateEnd = dateStart.plusDays(5);
        flightMission.setName(from.getName()+" to "+to.getName());
        flightMission.setStartDate(dateStart);
        flightMission.setEndDate(dateEnd);
        flightMission.setAssignedSpaceShip(spaceship);
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

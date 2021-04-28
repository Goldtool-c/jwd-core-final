package com.epam.jwd.core_final.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Expected fields:
 * <p>
 * missions name {@link String}
 * start date {@link java.time.LocalDate}
 * end date {@link java.time.LocalDate}
 * distance {@link Long} - missions distance
 * assignedSpaceShift {@link Spaceship} - not defined by default
 * assignedCrew {@link java.util.List<CrewMember>} - list of missions members based on ship capacity - not defined by default
 * missionResult {@link MissionResult}
 * from {@link Planet}
 * to {@link Planet}
 */
public class FlightMission extends AbstractBaseEntity {
    private LocalDate startDate;
    private LocalDate endDate;
    private double distance;
    private Spaceship assignedSpaceShip;
    private final int successRate=75;
    private List<CrewMember> assignedCrew;
    private MissionResult missionResult;
    private Planet from;
    private Planet to;
    public String getEndDate() { return endDate.toString(); }
    public String getStartDate() { return startDate.toString();}
    public void setName(String name) {
        this.name = name;
    }
    public String getAssignedSpaceship() {return assignedSpaceShip.name;}
    public LocalDate getStartDate1() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate1() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getDistance() { return (int) distance; }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Spaceship getAssignedSpaceShip() {
        return assignedSpaceShip;
    }

    public void setAssignedSpaceShip(Spaceship assignedSpaceShip) {
        this.assignedSpaceShip = assignedSpaceShip;
    }

    public List<CrewMember> getAssignedCrew() {
        return assignedCrew;
    }

    public void setAssignedCrew(List<CrewMember> assignedCrew) {
        this.assignedCrew = assignedCrew;
    }

    public MissionResult getMissionResult() {
        return missionResult;
    }

    public void setMissionResult(MissionResult missionResult) {
        this.missionResult = missionResult;
    }

    public String getFrom() {
        return from.name;
    }
    public void setFrom(Planet from) {
        this.from = from;
    }
    public String getTo() {return to.name;}
    public void setTo(Planet to) {
        this.to = to;
    }
// todo
}

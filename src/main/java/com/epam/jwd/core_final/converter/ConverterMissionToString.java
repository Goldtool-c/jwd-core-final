package com.epam.jwd.core_final.converter;

import com.epam.jwd.core_final.Repository.BaseEntityStorage;
import com.epam.jwd.core_final.domain.AbstractBaseEntity;
import com.epam.jwd.core_final.domain.FlightMission;

import java.util.ArrayList;

public enum  ConverterMissionToString {
    GENERAL;
    public String convert()
    {
        StringBuilder sb = new StringBuilder();
        ArrayList<FlightMission> temp = BaseEntityStorage.GENERAL.getFlightMission();
        sb.append("#name,to,from,startDate,assignedSpaceship;");
        for (int i = 0; i < temp.size(); i++) {
            sb.append(temp.get(i).getName()); sb.append(',');
            sb.append(temp.get(i).getTo()); sb.append(',');
            sb.append(temp.get(i).getFrom());sb.append(',');
            sb.append(temp.get(i).getStartDate());sb.append(',');
            sb.append(temp.get(i).getAssignedSpaceShip().getName());sb.append(';');
        }
        return sb.toString();
    }
}

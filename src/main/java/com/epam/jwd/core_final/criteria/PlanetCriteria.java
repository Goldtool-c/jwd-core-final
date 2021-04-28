package com.epam.jwd.core_final.criteria;

import com.epam.jwd.core_final.Repository.BaseEntityStorage;
import com.epam.jwd.core_final.domain.Planet;
import com.epam.jwd.core_final.exception.UnknownEntityException;

import java.awt.Point;
import java.util.ArrayList;

public class PlanetCriteria extends Criteria<Planet>{
    public Planet nameSearch(String name)
    {
        ArrayList<Planet> temp = BaseEntityStorage.GENERAL.getPlanetStorage();
        for (int i = 0; i < temp.size(); i++) {
            if(temp.get(i).getName().equals(name))
            {
                return temp.get(i);
            }
        }
        throw new UnknownEntityException("This object does not exist");
    }
    public Planet cordsSearch(Point point)
    {
        ArrayList<Planet> temp = BaseEntityStorage.GENERAL.getPlanetStorage();
        for (int i = 0; i < temp.size(); i++) {
            if(temp.get(i).getX()==point.getX()&&temp.get(i).getY()==point.getY())
            {
                return temp.get(i);
            }
        }
        throw new UnknownEntityException("This object does not exist");
    }
}

package com.epam.jwd.core_final.criteria;

import com.epam.jwd.core_final.Repository.BaseEntityStorage;
import com.epam.jwd.core_final.domain.BaseEntity;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.exception.UnknownEntityException;

import java.util.ArrayList;
public class SpaceshipCriteria extends Criteria<Spaceship> {
    public Spaceship nameSearch(String name)
    {
        ArrayList<Spaceship> temp = BaseEntityStorage.GENERAL.getShipStorage();
        for (int i = 0; i < temp.size(); i++) {
            if(temp.get(i).getName().equals(name))
            {
                return temp.get(i);
            }
        }
        throw new UnknownEntityException("This object does not exist");
    }
}

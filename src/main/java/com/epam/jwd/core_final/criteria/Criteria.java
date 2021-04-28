package com.epam.jwd.core_final.criteria;

import com.epam.jwd.core_final.Main;
import com.epam.jwd.core_final.Repository.BaseEntityStorage;
import com.epam.jwd.core_final.domain.BaseEntity;
import com.epam.jwd.core_final.domain.Planet;
import com.epam.jwd.core_final.exception.UnknownEntityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
public abstract class Criteria<T extends BaseEntity> {
    private static final Logger LOGGER = LoggerFactory.getLogger(Criteria.class);
    public T searchId(int id){
        T instance=null;
        ArrayList<T> temp = null;
        if(instance.getClass()==BaseEntityStorage.GENERAL.getFlightMission().get(0).getClass())
        {
            temp= (ArrayList<T>) BaseEntityStorage.GENERAL.getFlightMission();
        }
        if(instance.getClass()==BaseEntityStorage.GENERAL.getShipStorage().get(0).getClass())
        {
            temp= (ArrayList<T>) BaseEntityStorage.GENERAL.getShipStorage();
        }
        if(instance.getClass()==BaseEntityStorage.GENERAL.getCrewStorage().get(0).getClass())
        {
            temp= (ArrayList<T>) BaseEntityStorage.GENERAL.getCrewStorage();
        }
        if(instance.getClass()==BaseEntityStorage.GENERAL.getPlanetStorage().get(0).getClass())
        {
            temp= (ArrayList<T>) BaseEntityStorage.GENERAL.getPlanetStorage();
        }
        for (int i = 0; i < temp.size(); i++) {
            if(temp.get(i).getId()==id)
            {
                instance=temp.get(i);
                return instance;
            }
        }
        LOGGER.error("This ("+id+") object does not exist");
        throw new UnknownEntityException("This object does not exist");
    }
}

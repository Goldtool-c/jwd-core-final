package com.epam.jwd.core_final.domain;

import com.epam.jwd.core_final.Repository.TempValues;

import java.awt.Point;
import java.util.Objects;
public class Planet extends AbstractBaseEntity{
    private Point cords;
    public Planet()
    {

    }
    public Planet(String name, int x, int y) {
        this.name = name;
        cords = new Point(x, y);
        int id= TempValues.GENERAL.getId()+1;
        this.id=Integer.parseInt("1"+id);
        TempValues.GENERAL.setId(id);
    }
    public int getX(){return cords.x;}
    public int getY(){return cords.y;}
    public Point getCords() {
        return cords;
    }

    @Override
    public boolean equals(Object o) {
        boolean flag=false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        if(cords.getX()==planet.getX()&&cords.getY()==planet.getY()) return true;
        return Objects.equals(cords, planet.cords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cords);
    }
}

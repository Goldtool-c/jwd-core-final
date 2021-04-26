package com.epam.jwd.core_final.domain;

import javafx.geometry.Point2D;

import java.awt.*;

/**
 * Expected fields:
 * <p>
 * location could be a simple class Point with 2 coordinates
 */
public class Planet extends AbstractBaseEntity{
    Point cords;
    public Planet(String name, int x, int y) {
        this.name = name;
        cords = new Point(x, y);
    }
    public int getX(){return cords.x;}
    public int getY(){return cords.y;}
    public Point getCords() {
        return cords;
    }
}

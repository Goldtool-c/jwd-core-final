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
    public Planet(int x, int y) {
        cords = new Point(x, y);
    }

    public Point getCords() {
        return cords;
    }
}

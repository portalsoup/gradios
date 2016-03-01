package com.portalsoup.gradios.entity;


import java.awt.*;

/**
 * Created by julian on 2/27/2016.
 */
public class Player extends PaintableEntity {

    public Player(String name, double x, double y) {
        super(name, Polygon.PLAYER_SHIP, Color.RED, x, y);
    }

    public Player(String name) {
        this(name, 0, 0);
    }

    @Override
    public void update(long delta) {
        getComponents().forEach((component) -> component.update(this, delta));
        System.out.printf("Player \tx:%f\ty:%f\n", getCoordinates().getX(), getCoordinates().getY());
    }
}

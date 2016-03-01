package com.portalsoup.gradios;

/**
 * Created by julian on 2/27/2016.
 */
public class Coordinates {

    double x;
    double y;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {
        this(0, 0);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void transformX(double x) {
        this.x += x;
    }

    public void transformY(double y) {
        this.y += y;
    }
}

package com.portalsoup.gradios.entity;

import com.portalsoup.gradios.graphics.PolyType;

/**
 * Created by julian on 2/27/2016.
 */
public enum Polygon {

    PLAYER_SHIP(
            PolyType.QUAD,
            new int[] {0, 100, 100, 0, 100, 200, 200, 100},
            new int[] {0, 0, 100, 100, 100, 100, 200, 200}
    );

    private int[] x;
    private int[] y;
    private PolyType type;

    Polygon(PolyType type, int[] x, int[] y) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int[] getXCoordinates(int baseXCoord) {

        int[] x = new int[this.x.length];

        for (int i = 0; i < this.x.length; i++) {
            x[i] = baseXCoord + this.x[i] ;
        }

        return x;
    }

    public int[] getYCoordinates(int baseYCoord) {
        int[] y = new int[this.x.length];

        for (int i = 0; i < this.x.length; i++) {
            y[i] = baseYCoord + this.y[i] ;
        }

        return y;
    }

    public int getNumberOfPoints() {
        if (x.length != y.length) {
            throw new IllegalStateException("The number of x coordinates do not match the number of y coordinates!");
        }

        return x.length;
    }

    public PolyType getPolyType() {
        return type;
    }
}

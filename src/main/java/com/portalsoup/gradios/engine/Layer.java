package com.portalsoup.gradios.engine;

/**
 * Represents the graphics layer on the screen.  Layers will be drawn in order from distant to near in order to
 * guarantee the closest entities are drawn on top.  This
 *
 * Created by julian on 2/27/2016.
 */
public enum Layer {
    FAR(.25),
    MIDDLE(.5),
    NEAR(1);

    private double parallax;

    Layer(double parallax) {
        this.parallax = parallax;
    }

    /**
     * The farther away the entity is, the less distance it will appear to have moved.
     *
     * @param originalDistance  The distance of the entity calculated
     * @return
     */
    public double move(double originalDistance) {
        return originalDistance * parallax;
    }

}

package com.portalsoup.gradios.entity;

import com.portalsoup.gradios.Coordinates;
import org.lwjgl.opengl.GL11;

import java.awt.Color;
import java.util.Arrays;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by julian on 2/27/2016.
 */
public abstract class PaintableEntity extends Entity {

    private Polygon poly;
    private Color color;

    private Coordinates location;

    public PaintableEntity(String name, Polygon poly, Color color, double x, double y) {
        super(name);
        this.poly = poly;
        this.color = color;

        location = new Coordinates(x, y);
    }

    public PaintableEntity(String name, Polygon poly, Color color) {
        this(name, poly, color, 0, 0);
    }

    public Coordinates getCoordinates() {
        return location;
    }

    public void transformCoordinates(double x, double y) {
        getCoordinates().transformX(x);
        getCoordinates().transformY(y);
    }

    public Polygon getPoly() {
        return poly;
    }

    public Color getColor() {
        return color;
    }

    public void draw() {

        System.out.println("Blitting " + getName() + " location\t" +
                "X:" + Arrays.toString(poly.getXCoordinates((int) getCoordinates().getX())) + "\t" +
                "Y:" + Arrays.toString(poly.getYCoordinates((int) getCoordinates().getY())));

        switch (poly.getPolyType()) {
            case POINT:
                throw new UnsupportedOperationException("The point is not implemented");

            case LINE:
                throw new UnsupportedOperationException("The line is not implemented");

            case TRI:
                throw new UnsupportedOperationException("The triangle is not implemented");

            case QUAD:
                // set the color of the quad (R,G,B,A)
                glColor3f(color.getRed(), color.getGreen(), color.getBlue());

                // draw quad
                glBegin(GL11.GL_QUADS);

                int[] x = poly.getXCoordinates((int) location.getX());
                int[] y = poly.getYCoordinates((int) location.getY());

                for (int i = 0; i < poly.getNumberOfPoints(); i++) {
                    glVertex2f(x[i], y[i]);
                }

                glEnd();

                break;
            case TRI_FAN:
                throw new UnsupportedOperationException("The triangle fan is not implemented");
        }

    }
}

package com.portalsoup.gradios.graphics;

import com.portalsoup.gradios.entity.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;
import org.lwjgl.opengl.DisplayMode;

import javax.swing.*;
import java.io.Closeable;

import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

/**
 * Created by julian on 2/27/2016.
 */
public class Screen extends JFrame implements Closeable {

    private String name;
    private int xRes;
    private int yRes;


    public Screen(String name, int xRes, int yRes) {
        this.xRes = xRes;
        this.yRes = yRes;
        this.name = name;
    }

    public void init() throws LWJGLException {
        Display.setDisplayMode(new DisplayMode(xRes, yRes));
        Display.create();

        // init OpenGL
        glMatrixMode(GL11.GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 800, 0, 600, 1, -1);
        glMatrixMode(GL11.GL_MODELVIEW);
    }

    public void addEntity(PaintableEntity anEntity) {
    }

    public void repaint() {
        Display.update();
    }

    public void clearScreen() {
        GL11.glClearColor(0, 255, 0, 255);
        GL11.glClear (GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
    }

    @Override
    public void close() {
        Display.destroy();
    }
}

package com.portalsoup.gradios;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import java.util.Random;

import static org.lwjgl.opengl.Display.update;
import static org.lwjgl.opengl.GL11.*;

/**
 * Created by julian on 2/29/2016.
 */
public class LwjglDemo {

    private long lastFrame;

    public int getDelta() {
        long time = Sys.getTime();
        int delta = (int) (time - lastFrame);
        lastFrame = time;

        return delta;
    }

    public void start() throws InterruptedException {
        Random rand = new Random(System.currentTimeMillis());
        try {
            Display.setDisplayMode(new DisplayMode(800,600));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        // init OpenGL
        glMatrixMode(GL11.GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 800, 0, 600, 1, -1);
        glMatrixMode(GL11.GL_MODELVIEW);

        int size = 200;
        float
                a = size, b = size,
                c = size, d = size * 1.5f,
                e = size * 2, f = size * 1.25f;
        while (!Display.isCloseRequested()) {

            Thread.sleep(16);
            // Clear the screen and depth buffer
            glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

            // set the color of the quad (R,G,B,A)
            glColor3f(0.5f, 0.5f, 1.0f);

            // draw quad
            glBegin(GL11.GL_POLYGON);
            glVertex2f(a, b);
            glVertex2f(c, d);
            glVertex2f(e, f);
            //GL11.glVertex2f(g, h);
            glEnd();
            update();

            if (true) {
                a += (rand.nextBoolean() ? 1 : -1);
                b += (rand.nextBoolean() ? 1 : -1);
                c += (rand.nextBoolean() ? 1 : -1);
                d += (rand.nextBoolean() ? 1 : -1);
                e += (rand.nextBoolean() ? 1 : -1);
                f += (rand.nextBoolean() ? 1 : -1);
            }
        }

        Display.destroy();
    }
    public static void main(String[] argv) throws InterruptedException {
        LwjglDemo quadExample = new LwjglDemo();
        quadExample.start();
    }
}

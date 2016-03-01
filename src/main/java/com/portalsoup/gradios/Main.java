package com.portalsoup.gradios;

import com.portalsoup.gradios.engine.GameEngine;
import org.lwjgl.LWJGLException;

/**
 * Created by julian on 2/27/2016.
 */
public class Main {

    public static void main(String[] args) throws LWJGLException {

        GameEngine game = new GameEngine("Gradios");

        game.start();
    }
}

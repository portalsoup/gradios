package com.portalsoup.gradios.engine;

import com.portalsoup.gradios.graphics.Screen;

/**
 * Created by julian on 2/27/2016.
 */
public class Framerate {
    private int fps;

    private long lastFrame;

    public Framerate(int fps) {
        this.fps = fps;
        lastFrame = System.currentTimeMillis();
    }

    public long getDelay() {
        return 1000 / fps;
    }

    public int getFps() {
        return fps;
    }

    public boolean isNextFrame() {
        return getDelay() + lastFrame <= System.currentTimeMillis();
    }

    public long getDelta() {
        return System.currentTimeMillis() - lastFrame;
    }

    public void proceed(GameEngine engine, Screen screen) {
        if (isNextFrame()) {
            engine.update(getDelta());
            engine.render(screen);

            lastFrame = System.currentTimeMillis();
        }
    }
}

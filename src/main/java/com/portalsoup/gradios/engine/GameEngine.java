package com.portalsoup.gradios.engine;

import com.portalsoup.gradios.component.KeyboardMovement;
import com.portalsoup.gradios.entity.Entity;
import com.portalsoup.gradios.entity.PaintableEntity;
import com.portalsoup.gradios.entity.Player;
import com.portalsoup.gradios.graphics.Screen;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by julian on 2/27/2016.
 */
public class GameEngine {

    private String name;
    private int xRes;
    private int yRes;

    private Framerate fps;

    private List<Entity> nearEntities;
    private List<Entity> middleEntities;
    private List<Entity> farEntities;

    public GameEngine(String name, int xRes, int yRes) {
        this.name = name;
        this.xRes = xRes;
        this.yRes = yRes;

        this.fps = new Framerate(60);
        this.nearEntities = new ArrayList<>();
        this.middleEntities = new ArrayList<>();
        this.farEntities = new ArrayList<>();
    }

    public GameEngine(String name) {
        this(name, 500, 500);
    }

    public void start() throws LWJGLException {
        try (Screen screen = new Screen(name, xRes, yRes)) {

            initEntities();
            screen.init();

            while (!Display.isCloseRequested()) {
                System.out.printf("delta:%d\n", fps.getDelta());
                fps.proceed(this, screen);
                Display.sync(fps.getFps());
            }
        }
    }

    public void initEntities() throws LWJGLException {

        nearEntities.add(new Player("Player", 200, 200));
        nearEntities.get(0).addComponent(new KeyboardMovement());

    }

    public void update(long delta) {
        farEntities.stream().parallel().forEach((entity) -> entity.update(delta));
        middleEntities.stream().parallel().forEach((entity) -> entity.update(delta));
        nearEntities.stream().parallel().forEach((entity) -> entity.update(delta));
    }

    public void render(Screen screen) {

        // First clear the screen
        screen.clearScreen();

        // Now draw the entities in order of distance
        farEntities.forEach((entity) -> {
            if (entity instanceof PaintableEntity) {
                ((PaintableEntity) entity).draw();
            }
        });
        middleEntities.forEach((entity) -> {
            if (entity instanceof PaintableEntity) {
                ((PaintableEntity) entity).draw();
            }
        });
        nearEntities.forEach((entity) -> {
            if (entity instanceof PaintableEntity) {
                ((PaintableEntity) entity).draw();
            }
        });

        screen.repaint();

    }
}

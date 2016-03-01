package com.portalsoup.gradios.component;

import com.portalsoup.gradios.entity.Entity;
import org.lwjgl.input.Keyboard;

/**
 * Created by julian on 2/29/2016.
 */
public class KeyboardMovement extends MovementComponent {

    public KeyboardMovement() {
        super();
    }

    @Override
    public void update(Entity entity, long delta) {
        super.update(entity, delta);

        double MAX_SPEED = 100;
        double incrementSpeed = .1;

        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
            if (dy < MAX_SPEED) {
                dy += incrementSpeed;
            }
        } else {
            if (!Keyboard.isKeyDown(Keyboard.KEY_S)) {
                if (dy > 0) {
                    dy -= incrementSpeed;
                }
                if (dy < 0) {
                    dy = 0;
                }
            }

        } if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
            System.out.println("key a: dx: " + dx);
            if (dx > -MAX_SPEED) {
                dx -= incrementSpeed;
            }
        } else {
            if (!Keyboard.isKeyDown(Keyboard.KEY_D)) {
                if (dx < 0) {
                    dx += incrementSpeed;
                }
                if (dx > 0) {
                    dx = 0;
                }
            }

        } if (Keyboard.isKeyDown(Keyboard.KEY_S)) {

            if (dy > -MAX_SPEED) {
                dy -= incrementSpeed;
            }
        } else {
            if (!Keyboard.isKeyDown(Keyboard.KEY_W)) {
                if (dy < 0) {
                    dy += incrementSpeed;
                }
                if (dy > 0) {
                    dy = 0;
                }
            }

        } if (Keyboard.isKeyDown(Keyboard.KEY_D)) {

            if (dx < MAX_SPEED) {
                dx += incrementSpeed;
            }
        } else {
            if (!Keyboard.isKeyDown(Keyboard.KEY_A)) {
                if (dx > 0) {
                    dx -= incrementSpeed;
                }
                if (dx < 0) {
                    dx = 0;
                }
            }
        }
    }
}

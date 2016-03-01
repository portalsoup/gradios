package com.portalsoup.gradios.component;

import com.portalsoup.gradios.entity.Entity;
import com.portalsoup.gradios.entity.PaintableEntity;

/**
 * Created by julian on 2/29/2016.
 */
public abstract class MovementComponent implements Component {

    protected double dx;
    protected double dy;

    public MovementComponent() {
        dx = 0;
        dy = 0;
    }

    @Override
    public void update(Entity entity, long delta) {
        if (entity instanceof PaintableEntity) {
            PaintableEntity pEntity = (PaintableEntity) entity;

            pEntity.transformCoordinates(delta * dx, delta * dy);
        }
    }
}

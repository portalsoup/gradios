package com.portalsoup.gradios.component;

import com.portalsoup.gradios.entity.Entity;
import com.portalsoup.gradios.entity.PaintableEntity;


/**
 * Created by julian on 2/27/2016.
 */
public class SlidingComponent implements Component {
    @Override
    public void update(Entity entity, long delta) {
        if (entity instanceof PaintableEntity) {
            ((PaintableEntity) entity).transformCoordinates(5, 2);
        }
    }
}

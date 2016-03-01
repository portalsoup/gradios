package com.portalsoup.gradios.component;

import com.portalsoup.gradios.entity.Entity;

/**
 * Created by julian on 2/27/2016.
 */
public interface Component {

    void update(Entity entity, long delta);
}

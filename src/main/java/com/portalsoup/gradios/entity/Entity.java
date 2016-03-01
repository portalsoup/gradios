package com.portalsoup.gradios.entity;

import com.portalsoup.gradios.component.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by julian on 2/27/2016.
 */
public abstract class Entity {

    private String name;
    private List<Component> components;

    public Entity(String name) {
        this.name = name;
        components = new ArrayList<>();
    }

    public Entity addComponent(Component aComponent) {
        components.add(aComponent);
        return this;
    }

    public List<Component> getComponents() {
        return components;
    }

    public String getName() {
        return name;
    }

    public void update(long delta) {
        getComponents().forEach((component) -> component.update(this, delta));
    }
}

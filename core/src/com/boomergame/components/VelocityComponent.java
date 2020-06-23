package com.boomergame.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class VelocityComponent implements Component {

    private Vector2 velocity;

    public VelocityComponent(float velX, float velY) {
        this.velocity = new Vector2(velX, velY);
    }

    public Vector2 getVelocity() {
        return velocity;
    }
}

package com.boomergame.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class TransformComponent implements Component {
    private Vector2 position;
    private Vector2 scale;
    private float rotation = 0f;

    public Vector2 getPosition() {
        return this.position;
    }

    public Vector2 getScale() {
        return this.scale;
    }

    public float getRotation() {
        return this.rotation;
    }

    public void setPosition(Vector2 newPosition) {
        this.position = newPosition;
    }

    public void setScale(Vector2 newScale) {
        this.scale = newScale;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
}

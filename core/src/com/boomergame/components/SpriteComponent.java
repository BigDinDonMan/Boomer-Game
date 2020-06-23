package com.boomergame.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;

public class SpriteComponent implements Component {
    private Texture sprite;

    public SpriteComponent(Texture t) {
        this.sprite = t;
    }

    public Texture getSprite() {
        return sprite;
    }
}

package com.boomergame.systems;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.boomergame.components.SpriteComponent;

public class RenderSystem extends EntitySystem {
    private ImmutableArray<Entity> registeredEntities;
    private ComponentMapper<SpriteComponent> spriteMapper;

    public RenderSystem() {

    }

    @Override
    public void addedToEngine(Engine e) {
        super.addedToEngine(e);
        this.registeredEntities = e.getEntitiesFor(Family.all(SpriteComponent.class).get());
    }
}

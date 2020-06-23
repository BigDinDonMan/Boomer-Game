package com.boomergame.systems;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.Vector2;
import com.boomergame.components.TransformComponent;
import com.boomergame.components.VelocityComponent;

public class MovementSystem extends EntitySystem {

    private ComponentMapper<TransformComponent> transformMapper;
    private ComponentMapper<VelocityComponent> velocityMapper;
    private ImmutableArray<Entity> registeredEntities;

    public MovementSystem() {
        super();
        this.transformMapper = ComponentMapper.getFor(TransformComponent.class);
        this.velocityMapper = ComponentMapper.getFor(VelocityComponent.class);
    }

    @Override
    public void addedToEngine(Engine e) {
        super.addedToEngine(e);
        this.registeredEntities = e.getEntitiesFor(
                Family.all(TransformComponent.class, VelocityComponent.class).get()
        );
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        this.registeredEntities.forEach(e -> {
            TransformComponent transform = this.transformMapper.get(e);
            VelocityComponent velComp = this.velocityMapper.get(e);

            Vector2 currentPosition = transform.getPosition();
            Vector2 scale = transform.getScale();
            Vector2 velocity = velComp.getVelocity();
            currentPosition.x += velocity.x * scale.x * deltaTime;
            currentPosition.y += velocity.y * scale.y * deltaTime;
        });
    }
}

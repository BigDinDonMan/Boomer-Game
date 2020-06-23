package com.mygdx.game;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.boomergame.systems.AudioSystem;
import com.boomergame.systems.MovementSystem;

public class BoomerGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	Engine ECSEngine;

	Entity playerEntity;

	MovementSystem movementSystem;
	AudioSystem audioSystem;


	public BoomerGame() {
		super();
		this.ECSEngine = new Engine();
		this.playerEntity = new Entity();
		this.ECSEngine.addEntity(this.playerEntity);
		this.initializePlayerEntity();
		this.initializeGameSystems();
	}

	private void initializeGameSystems() {
        this.movementSystem = new MovementSystem();

        this.ECSEngine.addSystem(this.movementSystem);
	}

	private void initializePlayerEntity() {

	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}

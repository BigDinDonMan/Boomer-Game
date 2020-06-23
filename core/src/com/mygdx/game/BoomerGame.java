package com.mygdx.game;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.boomergame.core.GameConstants;
import com.boomergame.core.GameState;
import com.boomergame.systems.DisposableSystem;

import java.util.ArrayList;
import java.util.List;

public class BoomerGame extends ApplicationAdapter {

	Engine ECSEngine;
	List<DisposableSystem> systemsForCleanup;

	Entity playerEntity;

	World world;
	GameState gameState = GameState.MAIN_MENU;
    //<editor-fold> Game resources (init in create();)
	SpriteBatch mainBatch;
	SpriteBatch UIBatch;
	Texture img;
	OrthographicCamera gameCamera;
	ExtendViewport viewport;
	//</editor-fold>

	public BoomerGame() {
		super();
		this.ECSEngine = new Engine();
		this.world = new World(new Vector2(0, -10), true);
		this.playerEntity = new Entity();
		this.ECSEngine.addEntity(this.playerEntity);
		this.systemsForCleanup = new ArrayList<>();
	}

	@Override
	public void create () {
	    Box2D.init();
	    this.initializeGameResources();
	}

	@Override
	public void render () {
	    if (this.gameState != GameState.PAUSED) {
            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        }

		stepWorld();

		switch (this.gameState) {
            case MAIN_MENU:
                this.drawMainMenu();
                break;

            case PLAYING:
                this.drawGame();
                break;

            case PAUSED:
                this.drawPauseMenu();
                break;

            case HIGHSCORES:
                this.drawHighscores();
                break;

            case CREDITS:
                this.drawCredits();
                break;
        }

        this.updateGame(this.gameState);
	}

	private void updateGame(GameState state) {
	    switch (state) {
            case MAIN_MENU:
                break;
            case PLAYING:
                break;
            case PAUSED:
                break;
            case HIGHSCORES:
                break;
            case CREDITS:
                break;
        }
    }

	private float accumulator = 0;

	private void stepWorld() {
	    float delta = Gdx.graphics.getDeltaTime();
	    accumulator += Math.min(delta, 0.25f);
	    if (accumulator >= GameConstants.PHYSICS_STEP_TIME) {
	        accumulator -= GameConstants.PHYSICS_STEP_TIME;
            this.world.step(
                    GameConstants.PHYSICS_STEP_TIME,
                    GameConstants.VELOCITY_ITERATIONS,
                    GameConstants.POSITION_ITERATIONS
            );
        }
    }

	@Override
	public void dispose () {
        this.performCleanup();
	}

	@Override
    public void resize(int x, int y) {
        this.viewport.update(x, y, true);

        this.mainBatch.setProjectionMatrix(this.gameCamera.combined);
    }

    private void performCleanup() {
        mainBatch.dispose();
        UIBatch.dispose();
        img.dispose();
        this.disposeOfSystems();
    }

	private void disposeOfSystems() {
        this.systemsForCleanup.forEach(DisposableSystem::dispose);
    }

    private void initializeGameResources() {
        this.mainBatch = new SpriteBatch();
        this.UIBatch = new SpriteBatch();
        this.img = new Texture("badlogic.jpg");

        this.gameCamera = new OrthographicCamera();
        this.viewport = new ExtendViewport(
                800,
                600,
                this.gameCamera
        );
    }

    private void drawMainMenu() {

    }

    private void drawHighscores() {

    }

    private void drawCredits() {

    }

    private void drawGame() {

    }

    private void drawPauseMenu() {

    }
}

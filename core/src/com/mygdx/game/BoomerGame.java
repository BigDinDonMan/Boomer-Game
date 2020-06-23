package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.boomergame.screenmanagement.*;

public class BoomerGame extends Game {


	public SpriteBatch mainBatch;
	public SpriteBatch UIBatch;
	Texture img;


	MainMenuScreen menuScreen;
	OptionsScreen optionsScreen;
	MainGameScreen gameScreen;
	GameShopScreen shopScreen;
	CreditsScreen creditsScreen;

	public BoomerGame() {
		super();
	}

	private void createScreens() {
        this.menuScreen = new MainMenuScreen();
        this.optionsScreen = new OptionsScreen();
        this.gameScreen = new MainGameScreen();
        this.shopScreen = new GameShopScreen();
        this.creditsScreen = new CreditsScreen();
    }

	@Override
	public void create () {
	    Box2D.init();
	    this.initializeGameResources();
	    this.createScreens();
	    this.setScreen(this.menuScreen);
	}

	@Override
	public void render () {
	    this.getScreen().render(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void dispose () {
        this.performCleanup();
	}

	@Override
    public void resize(int x, int y) {
    }

    private void performCleanup() {
        mainBatch.dispose();
        UIBatch.dispose();
        img.dispose();

        this.menuScreen.dispose();
        this.creditsScreen.dispose();
        this.shopScreen.dispose();
        this.optionsScreen.dispose();
        this.gameScreen.dispose();
    }

    private void initializeGameResources() {
        this.mainBatch = new SpriteBatch();
        this.UIBatch = new SpriteBatch();
        this.img = new Texture("badlogic.jpg");
    }
}

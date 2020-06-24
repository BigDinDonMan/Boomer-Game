package com.boomergame.screenmanagement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.boomergame.core.GameConfiguration;

public class MainMenuScreen implements Screen {

    Stage stage;
    SpriteBatch batch;
    ExtendViewport viewport;
    TextureRegion buttonTextureRegion;
    TextureRegionDrawable drawableButtonRegion;
    Texture buttonTexture;
    Texture backgroundTexture;
    Skin skin;

    public MainMenuScreen() {
        this.batch = new SpriteBatch();
        this.viewport = new ExtendViewport(
                GameConfiguration.getResolutionWidth(),
                GameConfiguration.getResolutionHeight()
        );
        this.stage = new Stage(this.viewport, this.batch);
        this.backgroundTexture = new Texture(Gdx.files.internal("sprites/main_background.jpg"));
        this.skin = new Skin(Gdx.files.internal("sprites/main_menu/main_menu_skin.json"));
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this.stage);
        Table mainTable = new Table();
        mainTable.setFillParent(true);
        mainTable.top();

        //TODO: load texture drawables and assign it in here

        Label title;

        ImageTextButton startButton, exitButton, optionsButton, creditsButton, shopButton;
        startButton = new ImageTextButton("Start revenge!", this.skin);


        this.stage.addActor(mainTable);
        mainTable.add(startButton);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.batch.begin();
        this.batch.draw(
                this.backgroundTexture,
                0,
                0,
                GameConfiguration.getResolutionWidth(),
                GameConfiguration.getResolutionHeight()
        );
        this.batch.end();

        this.stage.act(Gdx.graphics.getDeltaTime());
        this.stage.draw();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        this.backgroundTexture.dispose();
        this.skin.dispose();
    }
}

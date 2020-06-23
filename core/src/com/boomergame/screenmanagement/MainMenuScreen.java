package com.boomergame.screenmanagement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.BoomerGame;

public class MainMenuScreen implements Screen {

    Stage stage;
    SpriteBatch batch;
    ExtendViewport viewport;
    OrthographicCamera camera;
    TextureRegion buttonTextureRegion;
    TextureRegionDrawable drawableButtonRegion;
    Texture buttonTexture;
    Texture backgroundTexture;

    public MainMenuScreen() {
        this.batch = new SpriteBatch();
        this.camera = new OrthographicCamera();
        this.viewport = new ExtendViewport(1280, 800, this.camera);
        this.stage = new Stage(this.viewport, this.batch);
        this.backgroundTexture = new Texture("main_background.jpg");
    }

    @Override
    public void show() {
        Table mainTable = new Table();
        mainTable.setFillParent(true);
        mainTable.top();

        this.stage.addActor(mainTable);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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
        this.buttonTexture.dispose();
        this.backgroundTexture.dispose();
    }
}

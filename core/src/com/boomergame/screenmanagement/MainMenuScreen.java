package com.boomergame.screenmanagement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.boomergame.core.GameConfig;

public class MainMenuScreen implements Screen {

    Stage stage;
    SpriteBatch batch;
    ExtendViewport viewport;
    TextureRegion buttonTextureRegion;
    TextureRegionDrawable drawableButtonRegion;
    Texture buttonTexture;
    Texture backgroundTexture;
    Skin skin;

    private static final int BUTTON_HEIGHT = 60;
    private static final int BUTTON_WIDTH = 170;

    public MainMenuScreen() {
        this.batch = new SpriteBatch();
        this.viewport = new ExtendViewport(
                GameConfig.getInstance().getResolutionX(),
                GameConfig.getInstance().getResolutionY()
        );
        this.stage = new Stage(this.viewport, this.batch);
        this.backgroundTexture = new Texture(Gdx.files.internal("sprites/main_background.jpg"));
        this.skin = new Skin(Gdx.files.internal("sprites/main_menu/main_menu_skin.json"));
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this.stage);
        initializeScreen();
    }

    private void initializeScreen() {
        Table mainTable = new Table();
        mainTable.setFillParent(true);
        mainTable.bottom();

        //TODO: load texture drawables and assign it in here

        Label title;

        TextButton startButton, exitButton, optionsButton, creditsButton, shopButton;
        startButton = new TextButton("Start revenge!", this.skin);
        exitButton = new TextButton("Quit", this.skin);
        optionsButton = new TextButton("Options", this.skin);
        creditsButton = new TextButton("Credits", this.skin);
        shopButton = new TextButton("Boomer Shop!", this.skin);

        int bottomPadding = 10;

        startButton.getLabelCell().center().padBottom(bottomPadding);
        exitButton.getLabelCell().center().padBottom(bottomPadding);
        optionsButton.getLabelCell().center().padBottom(bottomPadding);
        creditsButton.getLabelCell().center().padBottom(bottomPadding);
        shopButton.getLabelCell().center().padBottom(bottomPadding);

        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
        optionsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });
        creditsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });
        shopButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });

        this.stage.addActor(mainTable);
        mainTable.add(startButton).height(BUTTON_HEIGHT).width(BUTTON_WIDTH).center();
        mainTable.row();
        mainTable.add(shopButton).height(BUTTON_HEIGHT).width(BUTTON_WIDTH).center();
        mainTable.row();
        mainTable.add(optionsButton).height(BUTTON_HEIGHT).width(BUTTON_WIDTH).center();
        mainTable.row();
        mainTable.add(creditsButton).height(BUTTON_HEIGHT).width(BUTTON_WIDTH).center();
        mainTable.row();
        mainTable.add(exitButton).height(BUTTON_HEIGHT).width(BUTTON_WIDTH).center();
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
                GameConfig.getInstance().getResolutionX(),
                GameConfig.getInstance().getResolutionY()
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

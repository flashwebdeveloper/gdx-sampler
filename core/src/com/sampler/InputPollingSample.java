package com.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sampler.utils.GdxUtils;

public class InputPollingSample implements ApplicationListener {

    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private BitmapFont font;

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        camera = new OrthographicCamera();
        viewport = new FitViewport(1080, 720, camera);
        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("fonts/oswald-32.fnt"));
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        // Clear screen
        GdxUtils.clearScreen();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        draw();
        batch.end();
    }

    private void draw() {
        // Mouse/touch x/y
        int mouseX = Gdx.input.getX();
        int mouseY = Gdx.input.getY();

        // Buttons
        boolean leftPressed = Gdx.input.isButtonPressed(Input.Buttons.LEFT);
        boolean rightPressed = Gdx.input.isButtonPressed(Input.Buttons.RIGHT);

        font.draw(batch,
                "Mouse/Touch : x = " + mouseX + " y = " + mouseY,
                20f,
                720 - 20f);

        font.draw(batch,
                leftPressed ? "Left button pressed" : "Left button is not pressed",
                20f,
                720 - 60f);
        font.draw(batch,
                rightPressed ? "Right button pressed" : "Right button is not pressed",
                20f,
                720 - 100f);

        // Keys
        boolean wPressed = Gdx.input.isKeyPressed(Input.Keys.W);
        boolean sPressed = Gdx.input.isKeyPressed(Input.Keys.S);
        font.draw(batch,
                wPressed ? "W key pressed" : "W key is not pressed",
                20f,
                720 - 140f);
        font.draw(batch,
                sPressed ? "S key pressed" : "S key is not pressed",
                20f,
                720 - 180f);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}

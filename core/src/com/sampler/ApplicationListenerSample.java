package com.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Logger;

public class ApplicationListenerSample implements ApplicationListener {

    private boolean renderInterupted = true;

    private static final Logger log = new Logger(ApplicationListenerSample.class.getName(), Logger.DEBUG);

	@Override
	public void create() {
		// Used to initialize game and load resources
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        log.debug("create()");
	}

	@Override
	public void resize(int width, int height) {
		// Used to handle setting a new screen size
        log.debug("resize() width= " + width + " height= " + height);
	}

	@Override
	public void render() {
		// Used to render and update the game elements, called 60 times per second
        if (renderInterupted) {
            log.debug("render()");
            renderInterupted = false;
        }
	}

	@Override
	public void pause() {
		// Used to save game state when it looses focus, which doesn't involve the actual game play being paused unless the developer paused it
        log.debug("pause()");
        renderInterupted = true;
	}

	@Override
	public void resume() {
		// Used to handle the game coming back from being paused and restores game state
        log.debug("resume()");
        renderInterupted = true;
	}

	@Override
	public void dispose() {
		// Used to free resources and clean up
        log.debug("dispose()");
	}
}

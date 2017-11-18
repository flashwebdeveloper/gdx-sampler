package com.sampler.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by sanjib on 18/11/17.
 */

public class GdxUtils {
    private GdxUtils() {}

    public static void clearScreen(Color color) {
        // Clear screen
        Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public static void clearScreen() {
        // Clear screen
        clearScreen(Color.BLACK);
    }
}

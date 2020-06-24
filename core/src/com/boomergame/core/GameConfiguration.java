package com.boomergame.core;

public class GameConfiguration {
    private static int resolutionWidth = 1280;
    private static int resolutionHeight = 800;
    private static boolean resizable = false;

    public static final void setResolution(int width, int height) {
        resolutionHeight = height;
        resolutionWidth = width;
    }

    public static final int getResolutionWidth() {
        return resolutionWidth;
    }

    public static final int getResolutionHeight() {
        return resolutionHeight;
    }

    public static final boolean isResizable() {
        return resizable;
    }

    public static final void setResizable(boolean b) {
        resizable = b;
    }

    static {
        //TODO: create a config file with resolution and load it here
    }

    private GameConfiguration() {}
}

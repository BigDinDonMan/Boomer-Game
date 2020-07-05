package com.boomergame.core;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GameConfig {

    private static GameConfig instance = null;
    public static GameConfig getInstance() {
        return instance;
    }

    static {
        try {
            loadConfig();
        } catch (IOException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private static void loadConfig() throws IOException, NoSuchFieldException, IllegalAccessException {
        instance = new GameConfig();
        String path = System.getProperty("user.dir") + File.separator + "config.cfg";
        List<String> configLines = Files.readAllLines(Paths.get(path));
        for (String line : configLines) {
            String[] configData = line.split("=");
            String fieldName = configData[0];
            String fieldValue = configData[1];
            int integerFieldValue = 0;
            boolean boolFieldValue = false;
            boolean exceptionCaught = false;
            try {
                integerFieldValue = Integer.parseInt(fieldValue);
            } catch (NumberFormatException nfe) {
                boolFieldValue = Boolean.parseBoolean(fieldValue);
                exceptionCaught = true;
            }
            Field field = instance.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(instance, exceptionCaught ? boolFieldValue : integerFieldValue);
        }
    }


    private int resolutionX;
    private int resolutionY;
    private boolean vsync;
    private boolean resizable;
    private boolean fullscreen;

    public boolean saveOnQuit = false;

    private GameConfig() { }

    public int getResolutionX() {
        return resolutionX;
    }

    public void setResolutionX(int resolutionX) {
        this.resolutionX = resolutionX;
    }

    public int getResolutionY() {
        return resolutionY;
    }

    public void setResolutionY(int resolutionY) {
        this.resolutionY = resolutionY;
    }

    public boolean isVsync() {
        return vsync;
    }

    public void setVsync(boolean vsync) {
        this.vsync = vsync;
    }

    public boolean isResizable() {
        return resizable;
    }

    public void setResizable(boolean resizable) {
        this.resizable = resizable;
    }

    public boolean isFullscreen() {
        return fullscreen;
    }

    public void setFullscreen(boolean fullscreen) {
        this.fullscreen = fullscreen;
    }

    public void save() throws IOException {
        if (this.saveOnQuit) {
            String path = System.getProperty("user.dir") + File.separator + "config.cfg";
            Files.write(Paths.get(path), path.getBytes());
        }
    }
}

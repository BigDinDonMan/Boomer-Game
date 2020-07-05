package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.boomergame.core.GameConfig;
import com.mygdx.game.BoomerGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		GameConfig optionsConfig = GameConfig.getInstance();
		config.title = "Mr. Boomer's Revenge";
		config.height = optionsConfig.getResolutionY();
		config.width = optionsConfig.getResolutionX();
		config.resizable = optionsConfig.isResizable();
		config.vSyncEnabled = optionsConfig.isVsync();
		config.fullscreen = optionsConfig.isFullscreen();

		new LwjglApplication(new BoomerGame(), config);
	}
}

package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.boomergame.core.GameConfiguration;
import com.mygdx.game.BoomerGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Mr. Boomer's Revenge";
		config.height = 800;
		config.width = 1280;
		config.resizable = false;

		GameConfiguration.setResolution(1280, 800);

		new LwjglApplication(new BoomerGame(), config);
	}
}

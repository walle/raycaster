package me.ramblingsby.raycaster.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import me.ramblingsby.raycaster.Raycaster;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
    config.title = "Raycaster";
    config.width = 1024;
    config.height = 640;
		new LwjglApplication(new Raycaster(), config);
	}
}

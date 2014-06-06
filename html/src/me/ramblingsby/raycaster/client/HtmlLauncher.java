package me.ramblingsby.raycaster.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import me.ramblingsby.raycaster.Raycaster;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(1024, 640);
        }

        @Override
        public ApplicationListener getApplicationListener () {
                return new Raycaster();
        }
}
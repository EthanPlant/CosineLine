package churant.cosineline.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import churant.cosineline.GamCosineLine;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 506;
        config.height = 900;
        new LwjglApplication(new GamCosineLine(), config);
    }
}

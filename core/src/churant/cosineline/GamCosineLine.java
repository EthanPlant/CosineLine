package churant.cosineline;

import churant.cosineline.screens.scratch.ScrButtonScratch;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GamCosineLine extends Game {

    private SpriteBatch batch;
    public static int V_WIDTH = 1080;
    public static int V_HEIGHT = 1920;

    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new ScrButtonScratch(this));
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
    }
}

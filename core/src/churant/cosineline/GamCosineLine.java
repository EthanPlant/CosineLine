package churant.cosineline;

import churant.cosineline.screens.ScrGame;
import churant.cosineline.screens.ScrInstructions;
import churant.cosineline.screens.ScrMenu;
import churant.cosineline.screens.ScrStats;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GamCosineLine extends Game {

    private SpriteBatch batch;
    public static int V_WIDTH = 1080;
    public static int V_HEIGHT = 1920;
    
    private ScrGame scrGame;
    private ScrMenu scrMenu;
    private ScrInstructions scrInstructions;
    private ScrStats scrStats;

    @Override
    public void create() {
        batch = new SpriteBatch();
        scrMenu = new ScrMenu(this);
        scrInstructions = new ScrInstructions(this);
        scrStats = new ScrStats(this);
        updateState(0);
    }

    public SpriteBatch getBatch() {
        return batch;
    }
    
    public void updateState(int nScreen) {
        switch (nScreen) {
            case 0:
                setScreen(scrMenu);
                break;
            case 1:
                setScreen(new ScrGame(this));
                break;
            case 2:
                setScreen(scrInstructions);
                break;
            case 3:
                setScreen(scrStats);
                break;
        }
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

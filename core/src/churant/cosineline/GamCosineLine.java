package churant.cosineline;

import churant.cosineline.screens.ScrGame;
import churant.cosineline.screens.ScrInstructions;
import churant.cosineline.screens.ScrMenu;
import churant.cosineline.screens.ScrScratches;
import churant.cosineline.screens.scratch.ScrButtonScratch;
import churant.cosineline.screens.scratch.ScrCollisionScratch;
import churant.cosineline.screens.scratch.ScrMusicScratch;
import churant.cosineline.screens.scratch.ScrPlayerScratch;
import churant.cosineline.screens.scratch.ScrRandomGenScratch;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GamCosineLine extends Game {

    private SpriteBatch batch;
    public static int V_WIDTH = 1080;
    public static int V_HEIGHT = 1920;
    
    private ScrMenu scrMenu;
    private ScrInstructions scrInstructions;
    private ScrScratches scrStats;
    private ScrButtonScratch scrButtonScratch;
    private ScrPlayerScratch scrPlayerScratch;
    private ScrRandomGenScratch scrRandomScratch;
    private ScrCollisionScratch scrCollisionScratch;
    private ScrMusicScratch scrMusicScratch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        scrMenu = new ScrMenu(this);
        scrInstructions = new ScrInstructions(this);
        scrStats = new ScrScratches(this);
        scrButtonScratch = new ScrButtonScratch(this);
        scrPlayerScratch =  new ScrPlayerScratch(this);
        scrRandomScratch = new ScrRandomGenScratch(this);
        scrCollisionScratch = new ScrCollisionScratch(this);
        scrMusicScratch = new ScrMusicScratch(this);
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
            case 4:
                setScreen(scrButtonScratch);
                break;
            case 5:
                setScreen(scrPlayerScratch);
                break;
            case 6:
                setScreen(scrRandomScratch);
                break;
            case 7:
                setScreen(scrCollisionScratch);
                break;
            case 8:
                setScreen(scrMusicScratch);
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

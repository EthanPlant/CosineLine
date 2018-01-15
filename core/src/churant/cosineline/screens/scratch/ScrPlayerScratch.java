package churant.cosineline.screens.scratch;

import churant.cosineline.GamCosineLine;
import churant.cosineline.sprites.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ScrPlayerScratch implements Screen {
    
    private GamCosineLine game;
    
    private Viewport port;
    private OrthographicCamera cam;
    
    private Player plaPlayer;
    
    private Texture txBg;
    
    public ScrPlayerScratch(GamCosineLine game) {
        this.game = game;
        
        cam = new OrthographicCamera();
        port = new FitViewport(GamCosineLine.V_WIDTH, GamCosineLine.V_HEIGHT, cam);
        
        plaPlayer = new Player(port.getWorldWidth() / 2, 100);
        
        txBg = new Texture("playerscratchbg.jpg");
    }

    @Override
    public void show() {

    }
    
    public void handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            plaPlayer.setDeltaY(10);
        }
        if (!Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            plaPlayer.setDeltaY(0);
        }
    }
 
    @Override
    public void render(float delta) {
        handleInput();
        
        plaPlayer.update();
        cam.position.set(port.getWorldWidth() / 2, plaPlayer.getY() + 900, 0);
        
        cam.update();
        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        game.getBatch().setProjectionMatrix(cam.combined);
        game.getBatch().begin();
        game.getBatch().draw(txBg, 0, 0);
        plaPlayer.draw(game.getBatch());
        game.getBatch().end();
    }

    @Override
    public void resize(int width, int height) {
        port.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
    
}

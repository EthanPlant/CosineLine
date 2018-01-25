package churant.cosineline.screens;

import churant.cosineline.GamCosineLine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ScrScratches implements Screen {

    private Texture img;
    private GamCosineLine game;
    private OrthographicCamera cam;
    private Viewport port;
    private Texture txBackground;
    
    private Sprite sprButtonsBtn;
    private Sprite sprPlayerBtn;
    private Sprite sprRandomBtn;
    private Sprite sprCollisionBtn;
    private Sprite sprMusicBtn;

    public ScrScratches(GamCosineLine game) {
        this.game = game;
        cam = new OrthographicCamera();
        txBackground = new Texture("ScrGame.png");
        port = new FitViewport(GamCosineLine.V_WIDTH, GamCosineLine.V_HEIGHT, cam);
        cam.position.set(port.getWorldWidth() / 2, port.getWorldHeight() / 2, 0);
        
        sprButtonsBtn = new Sprite(new Texture("BtnButton.png"));
        sprButtonsBtn.setPosition(50, 800);
        
        sprPlayerBtn = new Sprite(new Texture("BtnPlayer.png"));
        sprPlayerBtn.setPosition(50, 1000);
        
        sprRandomBtn = new Sprite(new Texture("BtnRandomGen.png"));
        sprRandomBtn.setPosition(50, 1200);
        
        sprCollisionBtn = new Sprite(new Texture("BtnCollision.png"));
        sprCollisionBtn.setPosition(50, 1400);
        
        sprMusicBtn = new Sprite(new Texture("BtnMusic.png"));
        sprMusicBtn.setPosition(50, 600);
    }

    @Override
    public void show() {
    }
    
    public void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            game.updateState(0);   
        }
        
        if (Gdx.input.justTouched()) {
            Vector3 vInputPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            cam.unproject(vInputPos);
            if (sprButtonsBtn.getBoundingRectangle().contains(vInputPos.x, vInputPos.y)) {
                game.updateState(4);
            }
            if (sprPlayerBtn.getBoundingRectangle().contains(vInputPos.x, vInputPos.y)) {
                game.updateState(5);
            }
            if (sprRandomBtn.getBoundingRectangle().contains(vInputPos.x, vInputPos.y)) {
                game.updateState(6);
            }
            if (sprCollisionBtn.getBoundingRectangle().contains(vInputPos.x, vInputPos.y)) {
                game.updateState(7);
            }
            if (sprMusicBtn.getBoundingRectangle().contains(vInputPos.x, vInputPos.y)) {
                game.updateState(8);
            }
        }
    }

    @Override
    public void render(float delta) {
        handleInput();
        cam.update();

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getBatch().begin();
        game.getBatch().draw(txBackground, 0, 0);
        sprButtonsBtn.draw(game.getBatch());
        sprPlayerBtn.draw(game.getBatch());
        sprRandomBtn.draw(game.getBatch());
        sprCollisionBtn.draw(game.getBatch());
        sprMusicBtn.draw(game.getBatch());
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
        img.dispose();
    }
}

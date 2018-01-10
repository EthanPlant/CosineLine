package churant.cosineline.screens;

import churant.cosineline.GamCosineLine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ScrMenu implements Screen {

    private Texture img;
    private GamCosineLine game;
    private OrthographicCamera cam;
    private Viewport port;

    private Sprite sprPlayBtn;
    private Sprite sprInstructionsBtn;
    
    public ScrMenu(GamCosineLine game) {
        this.game = game;
        img = new Texture("ScrMenu.png");
        cam = new OrthographicCamera();
        port = new FitViewport(GamCosineLine.V_WIDTH, GamCosineLine.V_HEIGHT, cam);
        cam.position.set(port.getWorldWidth() / 2, port.getWorldHeight() / 2, 0);
        
        sprPlayBtn = new Sprite(new Texture("sprMain.png"));
        sprPlayBtn.setRotation(270);
        sprPlayBtn.setPosition(port.getWorldWidth() / 2 - sprPlayBtn.getWidth() / 2, 100);
        
        sprInstructionsBtn = new Sprite(new Texture("Instructions.png"));
        sprInstructionsBtn.setPosition(port.getWorldWidth() / - sprInstructionsBtn.getWidth() / 2, 700);
    }

    @Override
    public void show() {
    }
    
    public void handleInput() {
        if (Gdx.input.justTouched()) {
           Vector3 vInputPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
           cam.unproject(vInputPos);
           if (sprPlayBtn.getBoundingRectangle().contains(vInputPos.x, vInputPos.y)) {
               game.setScreen(new ScrGame(game));
           }
           if (sprPlayBtn.getBoundingRectangle().contains(vInputPos.x, vInputPos.y)) {
               game.setScreen(new ScrInstructions(game));
           }
        }
    }

    @Override
    public void render(float delta) {
        handleInput();
        
        cam.update();
        
        Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        game.getBatch().setProjectionMatrix(cam.combined);
        game.getBatch().begin();
        game.getBatch().draw(img, 0, 0);
        sprPlayBtn.draw(game.getBatch());
        sprInstructionsBtn.draw(game.getBatch());
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

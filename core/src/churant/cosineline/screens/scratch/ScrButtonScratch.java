package churant.cosineline.screens.scratch;

import churant.cosineline.GamCosineLine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ScrButtonScratch implements Screen {

    private GamCosineLine game;
    private Viewport port;
    private OrthographicCamera cam;
    
    private Sprite sprTest;
    
    public ScrButtonScratch(GamCosineLine game) {
        this.game = game;
        cam = new OrthographicCamera();
        port = new FitViewport(GamCosineLine.V_WIDTH, GamCosineLine.V_HEIGHT, cam);
        cam.position.set(port.getWorldWidth() / 2, port.getWorldHeight() / 2, 0);
        sprTest = new Sprite(new Texture("testbutton.png"));
        sprTest.setPosition(100, 100);
        
    }
    
    @Override
    public void show() {
        
    }
    
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            Vector3 vInputPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            cam.unproject(vInputPos);
            if(sprTest.getBoundingRectangle().contains(vInputPos.x, vInputPos.y)) {
                System.out.println("Button Hit");
            }
        }
    }

    @Override
    public void render(float delta) {
        handleInput();
        
        cam.update();
        
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        game.getBatch().setProjectionMatrix(cam.combined);
        game.getBatch().begin();
        sprTest.draw(game.getBatch());
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

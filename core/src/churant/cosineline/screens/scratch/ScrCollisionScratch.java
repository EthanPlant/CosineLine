package churant.cosineline.screens.scratch;

import churant.cosineline.GamCosineLine;
import churant.cosineline.sprites.CircleObstacle;
import churant.cosineline.sprites.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ScrCollisionScratch implements Screen {
    
    private GamCosineLine game;
    
    private Viewport port;
    private OrthographicCamera cam;
    
    private CircleObstacle obstacle;
    private Player player;
    
    public ScrCollisionScratch(GamCosineLine game) {
        this.game = game;
        cam = new OrthographicCamera();
        port = new FitViewport(GamCosineLine.V_WIDTH, GamCosineLine.V_HEIGHT, cam);
        cam.position.set(port.getWorldWidth() / 2, port.getWorldHeight() / 2, 0);
        
        obstacle = new CircleObstacle(100, 100, 100, 100);
        player = new Player(50, 50);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        cam.update();
        
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            game.updateState(0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            player.setDeltaY(5);
        }
        
        if (obstacle.getBoundingRectangle().overlaps(player.getBoundingRectangle())) {
            System.out.println("Hit obstacle!");
        }
        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        game.getBatch().setProjectionMatrix(cam.combined);
        game.getBatch().begin();
        player.draw(game.getBatch());
        obstacle.draw(game.getBatch());
        game.getBatch().end();
    }

    @Override
    public void resize(int width, int height) {

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

package churant.cosineline.screens;
//182, 182, 182
//53, 0, 106

import churant.cosineline.GamCosineLine;
import churant.cosineline.sprites.CircleObstacle;
import churant.cosineline.sprites.Obstacle;
import churant.cosineline.sprites.Player;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ScrGame implements Screen {

    private Texture img;
    private GamCosineLine game;
    private OrthographicCamera cam;
    private Viewport port;
    
    private Player plaPlayer;
    private float fSpeed;
    
    private Array<Obstacle> obstacles;
    private float fObstacleY, fObstacleTimer;

    public ScrGame(GamCosineLine game) {
        this.game = game;
        img = new Texture("ScrGame.png");
        cam = new OrthographicCamera();
        port = new FitViewport(GamCosineLine.V_WIDTH, GamCosineLine.V_HEIGHT, cam);
        cam.position.set(port.getWorldWidth() / 2, port.getWorldHeight() / 2, 0);
        
        plaPlayer = new Player(port.getWorldWidth() / 2, 100);
        fSpeed = 5;
        
        obstacles = new Array<Obstacle>();
        fObstacleY = 300;
    }

    @Override
    public void show() {
    }
    
    public void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
            plaPlayer.setMaxSpeed(20);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.X)) {
            plaPlayer.setMaxSpeed(40);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            game.updateState(0);   
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            plaPlayer.setDeltaY(fSpeed);
        }
        if (!Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            plaPlayer.setDeltaY(-1);
        }
        if (!Gdx.input.isKeyPressed(Input.Keys.Z) && !Gdx.input.isKeyPressed(Input.Keys.X)) {
            plaPlayer.setMaxSpeed(30);
        }
    }
    
    public void spawnObstacles(float delta) {
        fObstacleTimer += delta;
        if (fObstacleY < cam.position.y + 1500) {
            if (fObstacleTimer >= 0.01) {
                CircleObstacle obstacle = new CircleObstacle(MathUtils.random(10, 800), fObstacleY, 150, 150);
                obstacles.add(obstacle);
                fObstacleTimer = 0;
                fObstacleY += 1000;
            }
        }
    }

    @Override
    public void render(float delta) {
        handleInput();
        
        spawnObstacles(delta);
        
        plaPlayer.update();
        cam.position.set(port.getWorldWidth() / 2, plaPlayer.getY() + 900, 0);
        
        cam.update();
        
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        game.getBatch().setProjectionMatrix(cam.combined);
        game.getBatch().begin();
        game.getBatch().draw(img, 0, cam.position.y - 960);
        plaPlayer.draw(game.getBatch());
        for (Obstacle obstacle : obstacles) {
            obstacle.draw(game.getBatch());
            if (plaPlayer.getBoundingRectangle().contains(obstacle.getX(), obstacle.getY())) {
                game.updateState(0);
            }
            if (obstacle.getY() <= cam.position.y - 1500) {
                obstacles.removeIndex(obstacles.indexOf(obstacle, true));
                obstacles.shrink();
            }
        }
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
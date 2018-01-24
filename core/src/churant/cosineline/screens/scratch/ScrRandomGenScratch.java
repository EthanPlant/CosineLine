package churant.cosineline.screens.scratch;

import churant.cosineline.GamCosineLine;
import churant.cosineline.sprites.CircleObstacle;
import churant.cosineline.sprites.Obstacle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ScrRandomGenScratch implements Screen {

    GamCosineLine game;
    private Array<Obstacle> obstacles;
    private float fObstacleY;
    private float fObstacleTimer;
    private OrthographicCamera cam;
    private Viewport port;

    public ScrRandomGenScratch(GamCosineLine game) {
        this.game = game;
        obstacles = new Array<Obstacle>();
        fObstacleY = 5;
        cam = new OrthographicCamera();
        port = new FitViewport(GamCosineLine.V_WIDTH, GamCosineLine.V_HEIGHT, cam);
        cam.position.set(port.getWorldWidth() / 2, port.getWorldHeight() / 2, 0);
        fObstacleTimer = 0;
        CircleObstacle obstacle = new CircleObstacle(100, fObstacleY, 150, 150);
        obstacles.add(obstacle);
        fObstacleY += 1000;
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            game.updateState(0);
        }
        
        fObstacleTimer += delta;
        if (fObstacleTimer >= 0.01) {
            if (fObstacleY < cam.position.y + 1500) {
                float fX = MathUtils.random(5, 1000);
                CircleObstacle obstacle = new CircleObstacle(fX, fObstacleY, 150, 150);
                obstacles.add(obstacle);
                fObstacleTimer = 0;
                fObstacleY += 1000;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            cam.position.y += 50;
        }

        cam.update();


        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().setProjectionMatrix(cam.combined);
        game.getBatch().begin();
        for (Obstacle obstacle : obstacles) {
            obstacle.draw(game.getBatch());
            if (obstacle.getY() < cam.position.y - 1500) {
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
    }
}

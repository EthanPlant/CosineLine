package churant.cosineline.screens;

import churant.cosineline.GamCosineLine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ScrStats implements Screen {

    private Texture img;
    private GamCosineLine game;
    private OrthographicCamera cam;
    private Viewport port;
    private Texture txBackground;

    public ScrStats(GamCosineLine game) {
        this.game = game;
        cam = new OrthographicCamera();
        txBackground = new Texture("ScrInstructions.png");
        port = new FitViewport(GamCosineLine.V_WIDTH, GamCosineLine.V_HEIGHT, cam);
        cam.position.set(port.getWorldWidth() / 2, port.getWorldHeight() / 2, 0);
    }

    @Override
    public void show() {
    }
    
    public void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            game.updateState(0);   
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

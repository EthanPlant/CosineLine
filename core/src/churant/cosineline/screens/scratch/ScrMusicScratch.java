package churant.cosineline.screens.scratch;

import churant.cosineline.GamCosineLine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ScrMusicScratch implements Screen {

    private GamCosineLine game;
    
    private Viewport port;
    private OrthographicCamera cam;
    
    private Music music;
    
    public ScrMusicScratch(GamCosineLine game) {
        this.game = game;
        
        cam = new OrthographicCamera();
        port = new FitViewport(GamCosineLine.V_WIDTH, GamCosineLine.V_HEIGHT, cam);
        cam.position.set(port.getWorldWidth() / 2, port.getWorldHeight() / 2, 0);
        
        music = Gdx.audio.newMusic(Gdx.files.internal("bgm.mp3"));
    }
    
    @Override
    public void show() {
        music.play();
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            music.stop();
            game.updateState(0);
        }
        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        game.getBatch().setProjectionMatrix(cam.combined);
        game.getBatch().begin();
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

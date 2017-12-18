package churant.cosineline.screens;

import churant.cosineline.GamCosineLine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class ScrInstructions implements Screen {

        private Texture img;
        private GamCosineLine game;

        public ScrInstructions(GamCosineLine game) {
            this.game = game;
            img = new Texture("badlogic.jpg");
        }

        @Override
        public void show() {
        }

        @Override
        public void render(float delta) {
            Gdx.gl.glClearColor(0, 0, 1, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            game.getBatch().begin();
            game.getBatch().draw(img, 0, 0);
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
            img.dispose();
        }
    }

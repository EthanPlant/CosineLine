package churant.cosineline.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Obstacle extends Sprite {
    
    public Obstacle(float fX, float fY, float fLength, float fWidth) {
        setBounds(0, 0, fLength, fWidth);
        setSize(fLength, fWidth);
        setPosition(fX, fY);
    }
}

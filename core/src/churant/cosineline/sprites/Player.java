package churant.cosineline.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Player extends Sprite {
    
    private float fDx, fDy;
    
    public Player(float fX, float fY) {
        setBounds(0, 0, 200, 200);
        setRegion(new Texture("SprMain.png"));
        setSize(100, 100);
        setPosition(fX, fY);
        fDx = 10;
        fDy = 0;
    }
    
    public void update() {
        if (this.getX() <= 100) {
            fDx += 0.5;
        }
        if (this.getX() >= 800) {
            fDx -= 0.5;
        }
        setPosition(this.getX() + fDx, this.getY() + fDy);
    }
    
    public void setDeltaY(float fValue) {
        fDy += fValue;
    }
}

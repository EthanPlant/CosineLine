package churant.cosineline.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Player extends Sprite {

    private float fDx, fDy, fRotation;
    private boolean isRotated;

    public Player(float fX, float fY) {
        setBounds(0, 0, 200, 200);
        setRegion(new Texture("SprMain.png"));
        setSize(100, 100);
        setPosition(fX, fY);
        fDx = 20;
        fDy = 0;
        fRotation = 0;
        isRotated = false;
    }

    public void update() {
        if (this.getX() <= 200) {
            fDx += 1;
            if (isRotated == false) {
                fRotation -= 1;
                isRotated = !isRotated;
            } else if (isRotated == true) {
                fRotation -= 2;
            }
        }
        if (this.getX() >= 780) {
            fDx -= 1;
            if (isRotated == false) {
                fRotation += 1;
                isRotated = true;
                isRotated = !isRotated;
            } else if (isRotated == true) {
                fRotation += 2;
            }
        }
        
        setPosition(this.getX() + fDx, this.getY() + fDy);
        setRotation(fRotation);
    }

    public void setDeltaY(float fValue) {
        fDy = fValue;
    }
}

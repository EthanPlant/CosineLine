package churant.cosineline.sprites;

import churant.cosineline.GamCosineLine;
import com.badlogic.gdx.graphics.Texture;

public class MovingObstacle extends Obstacle {

    private float fDeltaX;

    public MovingObstacle(float fX, float fY, float fLength, float fWidth) {
        super(fX, fY, fLength, fWidth);
        setRegion(new Texture("MovingObstacle.png"));
        fDeltaX = 5;
    }

    @Override
    public void update(float delta) {
        if (this.getX() <= 0 || this.getX() >= GamCosineLine.V_WIDTH - this.getWidth()) {
            fDeltaX *= -1;
        }
        setPosition(this.getX() + fDeltaX, this.getY());
    }
}

package churant.cosineline.sprites;

import com.badlogic.gdx.graphics.Texture;

public class CircleObstacle extends Obstacle {
    
    public CircleObstacle(float fX, float fY, float fWidth, float fLength) {
        super(fX, fY, fWidth, fLength);
        setRegion(new Texture("Circle.png"));
    }
}

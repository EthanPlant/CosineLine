package churant.cosineline.sprites;

import com.badlogic.gdx.graphics.Texture;

public class CircleObstacle extends Obstacle {
    
    public CircleObstacle(float fX, float fY, float fLength, float fWidth) {
        super(fX, fY, fLength, fWidth);
        setRegion(new Texture("Circle.png"));
    }
}

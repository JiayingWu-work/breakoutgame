package breakout;
import edu.macalester.graphics.Rectangle;

/** 
 * A single brick which will be used to build the brick block
 */
public class Brick extends Rectangle{

    public Brick(double centerX, double centerY, double BRICK_WEIGHT, double BRICK_HEIGHT) {
        super(centerX, centerY, BRICK_WEIGHT, BRICK_HEIGHT);
    }
}

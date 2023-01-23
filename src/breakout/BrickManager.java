package breakout;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;

/** 
 * Manage the brick block that can be bounced off by the ball
 */
public class BrickManager {

    public static final double BRICK_WIDTH = 51;
    public static final double BRICK_HEIGHT = 15;

    private Color brickColor1 = new Color(164, 138, 112);
    private Color brickColor2 = new Color(107, 110, 93);
    private Color brickColor3 = new Color(156, 124, 126);
    private Color brickColor4 = new Color(186, 178, 168);
    private Color brickColor5 = new Color(128, 99, 101);
    
    /**
     * Constructor a brick manager for bricks
     */
    public BrickManager() {

    }

    /**
     * Build brick rows with different colors
     * @param upperLeftX
     * @param upperLeftY
     * @param color
     * @param canvas
     */
    public void buildRows(double upperLeftX, double upperLeftY, Color color, CanvasWindow canvas) {

        for (int i = 1; i < 11; i++) {
            Brick brick = new Brick(upperLeftX, upperLeftY, BRICK_WIDTH, BRICK_HEIGHT);

            brick.setFillColor(color);
            brick.setFilled(true);
            brick.setStroked(false);
            canvas.add(brick);

            upperLeftX = upperLeftX + 58;
        }
    }

    /**
     * Build brick block with different color rows
     * @param canvas
     */
    public void buildBlocks(CanvasWindow canvas) {

        double upperLeftX = 12.5;
        double upperLeftY = 120;
        List<Color> colorList = new ArrayList<>();
        colorList = List.of(brickColor1 , brickColor2, brickColor3, brickColor4, brickColor5);

        for (int i = 0; i < 5; i++) {    
            for (int j = 0; j < 2; j++) {
                new Brick(upperLeftX, upperLeftY, BRICK_WIDTH, BRICK_HEIGHT);
                buildRows(upperLeftX, upperLeftY, colorList.get(i),canvas);
                upperLeftY += 21;     
            }
        }
    }
}

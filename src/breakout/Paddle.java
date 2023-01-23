package breakout;
import java.awt.Color;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

/**
 * Represent a paddle that can bounce off the ball,
 * and move through mouse move
 */
public class Paddle extends Rectangle{

    private static final double PADDLE_WIDTH = 100;
    private static final double PADDLE_HEIGHT = 7;

    private Color paddleColor = new Color(118, 95, 96);
    private double centerX = 300;
    private double centerY = 680;
    
    private Paddle paddle;

    /**
     * Paddle constructor
     * @param centerX
     * @param centerY
     * @param width
     * @param height
     */
    public Paddle(double centerX, double centerY, double width, double height){
        super (centerX, centerY, width, height);
    }
    
    /**
     * Control the movement of a paddle through mouse move
     * @param canvas
     */
    public void movePaddle(CanvasWindow canvas) {

        this.paddle = new Paddle(centerX, centerY, PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle.setFillColor(paddleColor);
        paddle.setStrokeColor(paddleColor);
        canvas.add(paddle);
        
        canvas.onMouseMove(
            event -> {
                paddle.setPosition(event.getPosition().getX(), this.paddle.getY());
            });
    }
}

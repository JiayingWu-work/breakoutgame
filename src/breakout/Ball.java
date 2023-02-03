package breakout;
import java.awt.Color;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsObject;

/**
 * Represent a ball that can bounce off from walls and paddel, and wipe out bricks
 */
public class Ball {

    private static final double BALL_RADIUS = 10;
    private static final double maxX = 600;
    private static final double initialSpeed = 10;
    private Color ballColor = new Color(86, 54, 49);

    private double centerX = 300;
    private double centerY = 400;

    private double initialXVelocity;
    private double initialYVelocity;
    private GraphicsObject ballUp;
    private GraphicsObject ballDown;
    private GraphicsObject ballLeft;
    private GraphicsObject ballRight;
    private Ellipse ball;

    /**
     * Create a ball with its height, width, and velocity
     * @param x
     * @param y
     * @param width
     * @param height
     * @param canvas
     */
    public Ball(
        double x, 
        double y,
        double width,
        double height,
        CanvasWindow canvas){

        ball = new Ellipse(x, y, BALL_RADIUS, BALL_RADIUS);
        ball.setFilled(true);
        ball.setFillColor(ballColor);
        ball.setStroked(true);
        ball.setStrokeColor(ballColor);

        double initialAngleRadians = Math.toRadians(Math.random() * 180);
        
        initialXVelocity = initialSpeed * Math.cos(initialAngleRadians); 
        initialYVelocity = initialSpeed * Math.sin(initialAngleRadians); 
    }

    /**
     * Animates the ball to point at a new direction based on its velocity 
     * @param dt
     */
    public void updatePosition(double dt){
        double currentCenterX = this.centerX + dt * initialXVelocity;
        double currentCenterY = this.centerY + dt * initialYVelocity;
        this.centerX = currentCenterX;
        this.centerY = currentCenterY;
        ball.setPosition(currentCenterX, currentCenterY);
    }
//
//    public double getCenterX() {
//        return this.centerX;
//    }
//

    /**
     * Change direction and angle when ball hits the wall
     */
    public void wallCollision() {

        if (this.centerX > maxX || this.centerX < 0){
            initialXVelocity = -initialXVelocity;
        }

        if (this.centerY < 0){
            initialYVelocity = -initialYVelocity;
        }
    }

    /** 
     * Change direction and angle when ball hits the paddle
     */
    public void paddleCollison() {

        ballDown = ball.getCanvas().getElementAt(this.centerX,this.centerY + 5);
        
        if (ballDown instanceof Paddle) {
            initialYVelocity = -initialYVelocity;
        }
    }

    /**
     * Change direction and angle when ball hits the brick
     * Eliminate the brick after collision
     * @param canvas
     */
    public void brickCollison(CanvasWindow canvas) {

        ballUp = ball.getCanvas().getElementAt(this.centerX, this.centerY - 5);
        ballDown = ball.getCanvas().getElementAt(this.centerX,this.centerY + 5);
        ballLeft = ball.getCanvas().getElementAt(this.centerX - 5, this.centerY);
        ballRight = ball.getCanvas().getElementAt(this.centerX + 5, this.centerY);

        if (ballUp instanceof Brick) {
            canvas.remove(canvas.getElementAt(this.centerX, this.centerY - 5));
            initialYVelocity = -initialYVelocity;
        }

        else if (ballDown instanceof Brick) {
            canvas.remove(canvas.getElementAt(this.centerX,this.centerY + 5));
            initialYVelocity = -initialYVelocity;
        }

        else if (ballLeft instanceof Brick) {
            canvas.remove(canvas.getElementAt(this.centerX - 5, this.centerY));
            initialXVelocity = -initialXVelocity;
        }

        else if (ballRight instanceof Brick) {
            canvas.remove(canvas.getElementAt(this.centerX + 5, this.centerY));
            initialXVelocity = -initialXVelocity;
        }
    }

    /**
     * Add ball to the canvas
     * @param canvas
     */
    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(ball);
    }

    /**
     * Remove ball to the canvas
     * @param canvas
     */
    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(ball);
    }

    /**
     * Get ball's x coordinate 
     * @return
     */
    public double getCenterX() {
        return centerX;
    }

    /**
     * Get ball's y coordinate
     */
    public double getCenterY() {
        return centerY;
    }

}

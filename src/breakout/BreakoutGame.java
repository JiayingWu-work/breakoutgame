package breakout;
import java.util.ArrayList;

import edu.macalester.graphics.CanvasWindow;

/**
 * The game of Breakout.
 */
public class BreakoutGame {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;
    public static final double BRICK_WEIGHT = 50;
    public static final double BRICK_HEIGHT = 10;

    private double dt = 0.6;
    private static int death;

    private CanvasWindow canvas;
    private Paddle paddle;
    private Ball ball;
    private ArrayList<Ball> balls = new ArrayList<>();
    private BrickManager brickManager;

    /**
     *  Creates by Jiaying Wu on Oct 11, 2020
     */
    public static void main(String[] args){
        BreakoutGame game = new BreakoutGame();
        game.run();
    }

    /**
     * Setup the Breakout Game elements for the main method
     */
    public BreakoutGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        brickManager = new BrickManager();
        brickManager.buildBlocks(canvas);
    }

    /**
     * Run the breakout game and create the paddle for the game
     */
    public void run(){
        paddle = new Paddle(300, 680, 100, 7);
        paddle.movePaddle(canvas);
        playGame();
    }


    /**
     * Create ball method
     */
    private void createBall(){
        this.ball = new Ball(300, 400, 10, 10, canvas);
        this.ball.addToCanvas(canvas);
        balls.add(ball);
        canvas.draw();
    }

    /**
     * Play the breakout game and respond to win or lose condition
     */
    public void playGame() {

        for(int i = 0; i < 3; i++){
            createBall();
        }
        
        canvas.animate(()-> {

            if (death < 3){
                for(Ball balls : balls){
                    balls.updatePosition(dt);
                    balls.wallCollision();
                    balls.brickCollison(canvas);
                    balls.paddleCollison();
                }

            }

            if (death == 3){
                canvas.closeWindow();
            }

            if (ball.getCenterY() > 800){
                death ++;
                ball.removeFromCanvas(canvas);

                if (death < 3){
                    createBall();
                    canvas.pause(3000);
                }
            }
        });
    }
}


   

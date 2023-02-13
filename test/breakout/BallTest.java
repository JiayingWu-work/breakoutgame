package breakout;

import edu.macalester.graphics.CanvasWindow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    private Ball ball;
    private double centerX = 300;
    private double centerY = 400;
    private double initialXVelocity = 1;
    private double initialYVelocity = 1;
    private CanvasWindow canvas;


    @BeforeEach
    void setup() {
        canvas = new CanvasWindow("Test", 250, 150);
        ball = new Ball(100, 100, 10, 10, canvas);
    }


    @ParameterizedTest
    @ValueSource(ints = {10, 15, 50, 400, 300})
    void testUpdatePosition(int xPosition) {
        ball.getBall().setPosition(xPosition, 40);
        assertEquals(ball.getBall().getPosition().getX(), xPosition);
    }

    @Test
    void testBallMovement(){
        double currCenterX = ball.getCenterX();
        double currCenterY = ball.getCenterY();
        ball.updatePosition(10);
        assertFalse(currCenterX == ball.getCenterX());
        assertFalse(currCenterY == ball.getCenterY());
    }


}
package breakout;

import edu.macalester.graphics.CanvasWindow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    void testUpdatePosition() {
        ball.updatePosition(10);
        assertEquals(ball.getCenterX(), 110);
    }

}
package breakout;
import edu.macalester.graphics.CanvasWindow;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.mockito.Mockito.*;

public class MockitoTest {

    BreakoutGame breakoutGame = new BreakoutGame();
    Ball ball = mock(Ball.class);
    CanvasWindow canvas = mock(CanvasWindow.class);

    @Test
    public void mockRunGameTest() {
        breakoutGame.run();
        verify(breakoutGame, atLeast(1)).run();
    }

    @Test
    public void ballTest() {
       ball.updatePosition(10);
       verify(ball).updatePosition(10);
    }

    @Test
    public void ballTest2() {
        ball.getCenterY();
        when(ball.getCenterY()).thenReturn(10.0);
        verify(ball).getCenterY();
    }
}

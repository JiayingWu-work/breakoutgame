package breakout;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MockitoTest {

    BreakoutGame breakoutGame = mock(BreakoutGame.class);
    Ball ball = mock(Ball.class);

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
}

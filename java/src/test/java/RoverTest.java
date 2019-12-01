import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RoverTest {

    private ReportingModule reportingModule;
    private Rover rover;

    @BeforeEach
    void setUp() {
        reportingModule = mock(ReportingModule.class);
        rover = new Rover(reportingModule);
    }

    @Test
    void landingRobotReportsInitialPosition() {
        rover.land();

        Point initialPosition = new Point(0, 0);
        verify(reportingModule).reportPosition(initialPosition);
    }

    @Test
    void landingRobotReportsItsDirection() {
        rover.land();

        Direction initialDirection = Direction.NORTH;
        verify(reportingModule).reportDirection(initialDirection);
    }

    @Test
    void robotTurnsLeftAndReportsNewDirection() {
        rover.land();

        rover.executeCommands("l");

        Direction newDirection = Direction.WEST;
        verify(reportingModule).reportDirection(newDirection);
    }

    @Test
    void robotTurnsLeftAroundAndReportsNewDirection() {
        rover.land();

        rover.executeCommands("llll");

        Direction newDirection = Direction.NORTH;
        verify(reportingModule, atLeast(2)).reportDirection(newDirection);
    }

    @Test
    void robotTurnsRightAndReportsNewDirection() {
        rover.land();

        rover.executeCommands("r");

        Direction newDirection = Direction.EAST;
        verify(reportingModule).reportDirection(newDirection);
    }

    @Test
    void robotTurnsRightAroundAndReportsNewDirection() {
        rover.land();

        rover.executeCommands("rrrr");

        Direction newDirection = Direction.NORTH;
        verify(reportingModule, atLeast(2)).reportDirection(newDirection);
    }

    @Test
    void sendingInvalidCommandShouldThrowsAnException() {
        rover.land();

        assertThrows(UnsupportedOperationException.class,
            () -> rover.executeCommands("X"));
    }

    @Test
    void robotFacesNorthMovesForward() {
        rover.land();

        rover.executeCommands("f");

        Point newPosition = new Point(0, 1);
        verify(reportingModule).reportPosition(newPosition);
    }

    @Test
    void robotFacesNorthMovesForwardTwice() {
        rover.land();

        rover.executeCommands("ff");

        Point newPosition = new Point(0, 2);
        verify(reportingModule).reportPosition(newPosition);
    }

    @Test
    void robotFacesWestMovesForward() {
        rover.land();

        rover.executeCommands("lf");

        Point expectedPosition = new Point(-1, 0);
        verify(reportingModule).reportPosition(expectedPosition);
    }

    @Test
    void robotFacesSouthMovesForward() {
        rover.land();

        rover.executeCommands("llf");

        Point expectedPosition = new Point(0, -1);
        verify(reportingModule).reportPosition(expectedPosition);
    }

    @Test
    void robotFacesEastMovesForward() {
        rover.land();

        rover.executeCommands("rf");

        Point expectedPosition = new Point(1, 0);
        verify(reportingModule).reportPosition(expectedPosition);
    }

    @Test
    void robotFacesNorthMovesBackward() {
        rover.land();

        rover.executeCommands("b");

        Point newPosition = new Point(0, -1);
        verify(reportingModule).reportPosition(newPosition);
    }

    @Test
    void robotFacesEastMovesBackward() {
        rover.land();

        rover.executeCommands("rb");

        Point expectedPosition = new Point(-1, 0);
        verify(reportingModule).reportPosition(expectedPosition);
    }

    @Test
    void robotFacesSouthMovesBackward() {
        rover.land();

        rover.executeCommands("rrb");

        Point expectedPosition = new Point(0, 1);
        verify(reportingModule).reportPosition(expectedPosition);
    }

    @Test
    void robotFacesWestMovesBackward() {
        rover.land();

        rover.executeCommands("lb");

        Point expectedPosition = new Point(1, 0);
        verify(reportingModule).reportPosition(expectedPosition);
    }
}

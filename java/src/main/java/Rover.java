public class Rover {

    private final ReportingModule reportingModule;
    private Point currentPosition;
    private Direction currentDirection;

    public Rover(ReportingModule reportingModule) {
        this.reportingModule = reportingModule;
    }

    public void land() {
        currentPosition = new Point(0, 0);
        reportingModule.reportPosition(currentPosition);

        currentDirection = Direction.NORTH;
        reportingModule.reportDirection(currentDirection);
    }

    public void executeCommands(String commands) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'f':
                    currentPosition = currentPosition.forward(currentDirection);
                    break;
                case 'b':
                    currentPosition = currentPosition.backward(currentDirection);
                    break;
                case 'l':
                    currentDirection = currentDirection.left();
                    break;
                case 'r':
                    currentDirection = currentDirection.right();
                    break;
                default:
                    throw new UnsupportedOperationException("Unsupported command " + command);
            }
        }

        reportingModule.reportPosition(currentPosition);
        reportingModule.reportDirection(currentDirection);
    }
}

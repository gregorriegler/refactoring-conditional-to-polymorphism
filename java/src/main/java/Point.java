import java.util.Objects;

public class Point {
    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point forward(Direction direction) {
        switch (direction) {
            case NORTH:
                return new Point(x, y + 1);
            case EAST:
                return new Point(x + 1, y);
            case SOUTH:
                return new Point(x, y - 1);
            case WEST:
                return new Point(x - 1, y);
            default:
                // never invoked
                throw new IllegalArgumentException("unknown forward direction: " + direction);
        }
    }

    public Point backward(Direction direction) {
        switch(direction) {
            case NORTH:
                return new Point(x, y - 1);
            case EAST:
                return new Point(x - 1, y);
            case SOUTH:
                return new Point(x, y + 1);
            case WEST:
                return new Point(x + 1, y);
            default:
                // never invoked
                throw new IllegalArgumentException("unknown backward direction: " + direction);
        }
    }

    @Override
    public String toString() {
        return "{" + x + ", " + y + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

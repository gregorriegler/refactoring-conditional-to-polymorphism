public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction left() {
        int left = ordinal() - 1;
        if (left < 0) {
            left = values().length - 1;
        }
        return Direction.values()[left];
    }

    public Direction right() {
        int right = ordinal() + 1;
        if (right >= values().length) {
            right = 0;
        }
        return Direction.values()[right];
    }

}

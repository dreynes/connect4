package model;

public enum Direction {

    WEST(0,-1),
    EAST(0,1),
    SOUTH(-1,0),
    SOUTHEAST(-1,1),
    SOUTHWEST(-1,-1);

    private int verticalDirection;
    private int horizontalDirection;
    Direction(int verticalDirection, int horizontalDirection) {
        this.horizontalDirection = horizontalDirection;
        this.verticalDirection = verticalDirection;
    }

}

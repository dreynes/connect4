package model;


public enum Direction {

    EAST(0,1),
    WEST(0,1),
    NORTH(1,0),
    SOUTH(-1,0),
    NORTHEAST(1,1),
    SOUTHWEST(-1,-1),
    NORTHWEST(1,-1),
    SOUTHEAST(-1,1);

    private  int verticalDirection;
    private  int horizontalDirection;

    Direction(int verticalDirection, int horizontalDirection) {
        this.horizontalDirection = horizontalDirection;
        this.verticalDirection = verticalDirection;
    }

    public int getHorizontalDirection() {
        return this.horizontalDirection;
    }
    public int getVerticalDirection() {
        return this.verticalDirection;
    }

    public Direction  invertDirection(int ordinal){
        if(ordinal%2 == 0)
            ordinal++;
        else
            ordinal--;
        return Direction.values()[ordinal];
    }
}

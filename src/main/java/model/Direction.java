package model;


public enum Direction {

    EAST(1,0),
    WEST(-1,0),
    NORTH(0,1),
    SOUTH(0,-1),
    NORTHEAST(1,1),
    SOUTHWEST(-1,-1),
    NORTHWEST(-1,1),
    SOUTHEAST(1,-1);

    private  int verticalDirection;
    private  int horizontalDirection;

    Direction( int horizontalDirection, int verticalDirection) {
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

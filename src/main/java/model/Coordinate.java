package model;

public class Coordinate {
    private final int row;
    private final int column;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }
    public int getColumn() {
        return this.column;
    }

    public Coordinate move(Direction direction){
        return new Coordinate(this.getRow() + direction.getVerticalDirection(),
                            this.getColumn() + direction.getHorizontalDirection());
    }

    public boolean isCoordinateInRange(int numRows, int numColumns) {
        int row = this.getRow();
        int column = this.getColumn();
        return row < numRows && row >= 0 &&
                column < numColumns && column >= 0;
    }
}


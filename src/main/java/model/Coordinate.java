package model;

public class Coordinate {
    private int row;
    private int column;

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
        return new Coordinate(this.getRow() + direction.getHorizontalDirection(),
                                this.getColumn() + direction.getVerticalDirection());
    }


    public Coordinate moveOposite(Direction direction){
        return new Coordinate(this.getRow() + (direction.getHorizontalDirection()*(-1)),
                this.getColumn() + (direction.getVerticalDirection()*(-1)));
    }

}


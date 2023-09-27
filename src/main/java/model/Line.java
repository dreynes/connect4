package model;

public class Line {

    public static final int LINE_LENGTH = 4;
    private  final Coordinate[] line;

    private  final Direction direction;


    public Line (Coordinate coordinate, Direction direction) {
        this.direction = direction;
        line = new Coordinate[LINE_LENGTH];
        line[0] = coordinate;
        for(int i = 1; i < LINE_LENGTH; i++) {
            line[i] = line[i - 1].move(direction);
        }
    }

    public Coordinate getHead() {
        return this.line[0];
    }

    public Coordinate getTail() {
        return this.line[LINE_LENGTH - 1];
    }

    public Coordinate getCoordinate(int i){
        return this.line[i];
    }
    public void displace() {
        for(int i = 0; i < line.length; i++) {
            line[i] = line[i].moveOpposite(direction);
        }
    }
}

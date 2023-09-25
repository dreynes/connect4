package model;

public class Line {

    private Coordinate[] line;

    private Direction direction;


    public Line (Coordinate coordinate, Direction direction) {
        this.direction = direction;
        int originRow;
        line = new Coordinate[4];
        line[0] = coordinate;
        for(int i = 1; i<LineSize-1; i++) {
            line[i] = line[i-1].move();
        }
    }
    public int getStartCoordinate(int coordinate){
        int answer;
        if(coordinate<3)
            answer = 0;
        else
            answer = coordinate-3;
        return answer;
    }

    public void desplaze() {

    }
}

package model;

public class Board {
    private final Token[][] tokens;
    private Coordinate lastPosition;
    public static final int NUM_ROWS = 6;
    public static final int NUM_COLUMNS = 7;

    public Board() {
        this.tokens = new Token[NUM_ROWS][NUM_COLUMNS];
        this.reset();
    }

    public void reset(){
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int column = 0; column < NUM_COLUMNS; column++) {
                this.setTokenAt(new Coordinate(row, column), Token.NONE);
            }
        }
    }

    public void putPiece(int column, Token token) {
        boolean gap = false;
        Coordinate coordinate = new Coordinate(0, column);
        do{
            if(this.getTokenAt(coordinate) == Token.NONE){
                gap = true;
            }
            else
                coordinate = coordinate.move(Direction.NORTH);
        }while((!gap) && coordinate.isCoordinateInRange(NUM_ROWS, NUM_COLUMNS));

        this.setTokenAt(coordinate, token);
        this.lastPosition = coordinate;
    }

    public boolean enableColumn(int column) {
        if (column < 0 || column > NUM_COLUMNS - 1 ) {
            Error.OUT_OF_RANGE.writeln();
            return false;
        }
        if(this.tokens[NUM_ROWS - 1][column] != Token.NONE) {
            Error.COLUMN_FULL.writeln();
            return false;
        }
        return true;
    }

    public boolean checkVictory() {
        boolean answer = false;
        for(Direction direction : Direction.values()){
            answer = answer || this.checkLineIsConnect4(new Line(lastPosition, direction));
        }
        return answer;
    }

    public boolean checkLineIsConnect4(Line line){
       boolean isConnect4 = false;
       for(int j = 0; j<4 && !isConnect4; j++ ) {
           if (!line.isLineInRange(NUM_ROWS, NUM_COLUMNS)) {
               return false;
           }
           isConnect4 = isLineConnect4(line);
           line.displace();
       }
        return isConnect4;
    }

    public boolean isLineConnect4(Line line){
        boolean lineConnect4 = true;
        for (int i = 0; i < 4 && lineConnect4; i++) {
            lineConnect4 = this.getTokenAt(this.lastPosition) == this.getTokenAt(line.getCoordinate(i));
        }
        return lineConnect4;

    }

    public boolean isBoardFull() {
        for (int column = 0; column < NUM_COLUMNS; column++) {
            if (this.isTokenNone(new Coordinate(5, column))) {
                return false;
            }
        }
        return true;
    }

    public boolean isTokenNone(Coordinate coordinate) {
        return this.getTokenAt(coordinate) == Token.NONE;
    }

    public Token getTokenAt(Coordinate coordinate) {
        return this.tokens[coordinate.getRow()][coordinate.getColumn()];
    }

    public void setTokenAt(Coordinate coordinate, Token token) {
        this.tokens[coordinate.getRow()][coordinate.getColumn()] = token;
    }


}

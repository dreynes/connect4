package model;

public class Board {
    private Token[][] tokens;
    private Coordinate lastPosition;
    public static final int NUM_ROWS = 6;
    public static final int NUM_COLUMNS = 7;

    public Board() {
        this.tokens = new Token[NUM_ROWS][NUM_COLUMNS];
        this.reset();
    }

    public void dropPiece(int column, Token token) {
        boolean dropped = false;
        int row = 0;
        do{
            if (this.tokens[row][column] == Token.NONE) {
                this.tokens[row][column] = token;
                this.lastPosition =  new Coordinate(row, column);
                dropped = true;
            }
            row++;
        } while(!dropped && row<NUM_ROWS);
    }

    public boolean enableColumn(int column) {
        if (column < 0 || column > NUM_COLUMNS - 1 ) {
            Error.OUT_OF_RANGE.writeln();
            return false;
        }
        if(this.tokens[5][column] != Token.NONE) {
            Error.COLUMN_FULL.writeln();
            return false;
        }
        return true;
    }

    public boolean checkVictory(Token color) {
        boolean answer = false;
        for(Direction direction : Direction.values()){
            answer = answer || checkLineIsConnect4(new Line(lastPosition, direction));
        }
        return answer;
    }


    public boolean checkLineIsConnect4(Line line){
        if(!this.isLineInRange(line))
            return false;
        boolean connect4 = true;
        for(int i = 0; (i<4)&&connect4; i++){
            connect4 = getTokenAt(this.lastPosition) == getTokenAt(line.getCoordinate(i));
        }
        if(!connect4) {
            line.displace();
            checkLineIsConnect4(line);
        }
        return connect4;
    }
    public boolean isLineInRange(Line line) {
        return isCoordinateInRange(line.getCoordinate(0)) &&
                isCoordinateInRange(line.getCoordinate(3));
   }

    public boolean isCoordinateInRange(Coordinate coordinate) {
        int row = coordinate.getRow();
        int column = coordinate.getColumn();
      return row < NUM_ROWS &&
              row >= 0 &&
              column >= 0 &&
              column < NUM_COLUMNS;

    }

    public void print() {
        for (int row = NUM_ROWS - 1; row >= 0; row--) {
            for (int column = 0; column < NUM_COLUMNS; column++) {
                System.out.print(this.tokens[row][column].getTokenName() + " ");
            }
            System.out.println();
        }
    }

    public boolean isBoardFull() {
        for (int column = 0; column < NUM_COLUMNS; column++) {
            for (int row = 0; row < NUM_ROWS; row++) {
                if (this.isTokenNone(new Coordinate(row, column))) {
                    return false;
                }
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

    public void reset(){
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int column = 0; column < NUM_COLUMNS; column++) {
                tokens[row][column] = Token.NONE;
            }
        }
    }

}

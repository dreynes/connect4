
public class Board {
    private Token[][] tokens;
    private Solution solution;

    private final int NUM_ROWS = 6;
    private final int NUM_COLUMNS = 7;

    public Board() {
        tokens = new Token[NUM_ROWS][NUM_COLUMNS];
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int column = 0; column < NUM_COLUMNS; column++) {
                tokens[row][column] = Token.NONE;
            }
        }
        solution = new Solution();
    }

    public boolean dropPiece(int column, Token color) {
        for (int row = 0; row < NUM_ROWS; row++) {
            if (tokens[row][column] == Token.NONE) {
                tokens[row][column] = color;
                return true;
            }
        }
        return false;
    }

    public boolean enableColumn(int column) {
        if (column < 0 || column > NUM_COLUMNS - 1 ) {
            Error.OUT_OF_RANGE.writeln();
            return false;
        }
        if(tokens[5][column] != Token.NONE) {
            Error.COLUMN_FULL.writeln();
            return false;
        }
        return true;
    }

    public boolean checkVictory(Token color) {
        return  solution.checkVictoryHorizontal(this, color) ||
                solution.checkVictoryVertical(this, color) ||
                solution.checkVictoryDiagonalAsc(this, color) ||
                solution.checkVictoryDiagonalDesc(this, color);
    }

    public void print() {
        for (int row = NUM_ROWS - 1; row >= 0; row--) {
            for (int column = 0; column < NUM_COLUMNS; column++) {
                System.out.print(tokens[row][column].getToken() + " ");
            }
            System.out.println();
        }
    }

    public boolean isBoardFull() {
        for (int column = 0; column < NUM_COLUMNS; column++) {
            for (int row = 0; row < NUM_ROWS; row++) {
                if (isTokenNone(row, column)) {
                    return false;
                }
            }
        }
        return true;
    }

    public Token getColorOnPosition(int row, int column) {
        return tokens[row][column];
    }

    public boolean isTokenNone(int row, int column) {
        return getColorOnPosition(row, column) == Token.NONE;
    }
}

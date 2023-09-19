
public class Board {

    private Token[][] tokens;
    private Solution solution;

    public Board() {
        tokens = new Token[6][7];
        for (int row = 0; row < 6; row++) {
            for (int column = 0; column < 7; column++) {
                tokens[row][column] = Token.NONE;
            }
        }
        solution = new Solution();
    }

    public boolean dropPiece(int column, Token color) {
        for (int row = 0; row < 6 ; row++) {
            if (tokens[row][column] == Token.NONE) {
                tokens[row][column] = color;
                return true;
            }
        }
        return false;
    }

    public boolean eneableColumn(int column) {

        if (column < 0 || column > 6 || tokens[5][column] != Token.NONE) {
            return false;
        }
        return true;
    }

    public boolean checkVictory(Token color) {

        return  solution.checkVictoryHorizontal(this, color) || solution.checkVictoryVertical(this, color)
                || solution.checkVictoryDiagonalAsc(this, color) || solution.checkVictoryDiagonalDesc(this, color);

    }

    public void printBoard() {
        for (int i = 5; i >=0; i--) {
            for (int j = 0; j < 7; j++) {
                System.out.print(tokens[i][j].getToken() + " ");
            }
            System.out.println();
        }
    }

    public boolean isBoardFull() {
        for (int column = 0; column < 6; column++) {
            for (int row = 0; row < 5; row++) {
                if (tokens[row][column] == Token.NONE) {
                    return false;
                }
            }
        }
        return true;
    }

    public Token getColorOnPosition(int row, int column) {
        return tokens[row][column];
    }
}

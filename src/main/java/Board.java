
public class Board {

    private Token[][] tokens;


    public Board() {
        tokens = new Token[6][7];
        for (int row = 0; row < 6; row++) {
            for (int column = 0; column < 7; column++) {
                tokens[row][column] = Token.NONE;
            }
        }
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

        return  checkVictoryHorizontal(color) || checkVictoryVertical(color)
                || checkVictoryDiagonalAsc(color) || checkVictoryDiagonalDesc(color);

    }


    private boolean checkVictoryVertical(Token color) {
        for (int column = 0; column < 6; column++) {
            for (int row = 0; row <= 2; row++) {
                if (tokens[row][column] == color &&
                        tokens[row][column + 1] == color &&
                        tokens[row][column + 2] == color &&
                        tokens[row][column + 3] == color) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVictoryHorizontal(Token color) {
        for (int row = 0; row <= 3; row++) {
            for (int column = 0; column < 6; column++) {
                if (tokens[row][column] == color &&
                        tokens[row + 1][column] == color &&
                        tokens[row + 2][column] == color &&
                        tokens[row + 3][column] == color) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVictoryDiagonalDesc(Token color) {

        for (int row = 0; row < 3; row++) {
            for (int column = 5; column >= 4; column--) {
                if (tokens[row][column] == color &&
                        tokens[row + 1][column - 1] == color &&
                        tokens[row + 2][column - 2] == color &&
                        tokens[row + 3][column - 3] == color) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVictoryDiagonalAsc(Token color) {
        for (int column = 0; column <= 3; column++) {
            for (int row = 0; row <= 2; row++) {
                if (tokens[row][column] == color &&
                        tokens[row + 1][column + 1] == color &&
                        tokens[row + 2][column + 2] == color &&
                        tokens[row + 3][column + 3] == color) {
                    return true;
                }
            }
        }

        return false;
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

}

public class Solution {
    public boolean checkVictoryVertical(Board board, Token color) {
        for (int column = 0; column < 6; column++) {
            for (int row = 0; row <= 2; row++) {
                if (board.getColorOnPosition(row, column) == color &&
                    board.getColorOnPosition(row, column + 1) == color &&
                    board.getColorOnPosition(row, column + 2) == color &&
                    board.getColorOnPosition(row, column + 3) == color) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkVictoryHorizontal(Board board, Token color) {
        for (int row = 0; row <= 3; row++) {
            for (int column = 0; column < 6; column++) {
                if (board.getColorOnPosition(row, column) == color &&
                    board.getColorOnPosition(row + 1, column) == color &&
                    board.getColorOnPosition(row + 2, column) == color &&
                    board.getColorOnPosition(row + 3, column) == color) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkVictoryDiagonalDesc(Board board, Token color) {

        for (int row = 0; row < 3; row++) {
            for (int column = 5; column >= 4; column--) {
                if (board.getColorOnPosition(row, column) == color &&
                    board.getColorOnPosition(row + 1, column - 1) == color &&
                    board.getColorOnPosition(row + 2, column - 2) == color &&
                    board.getColorOnPosition(row + 3, column - 3) == color) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkVictoryDiagonalAsc(Board board, Token color) {
        for (int column = 0; column <= 3; column++) {
            for (int row = 0; row <= 2; row++) {
                if (board.getColorOnPosition(row, column) == color &&
                    board.getColorOnPosition(row + 1, column + 1) == color &&
                    board.getColorOnPosition(row + 2, column + 2) == color &&
                    board.getColorOnPosition(row + 3, column + 3) == color) {
                    return true;
                }
            }
        }

        return false;
    }
}

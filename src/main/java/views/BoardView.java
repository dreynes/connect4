package views;
import model.*;

public class BoardView {
    public void write(Game game) {
        for (int i = Board.NUM_ROWS - 1; i >= 0; i--) {
            for (int j = 0; j < Board.NUM_COLUMNS; j++) {
                new TokenView().write(game.getToken(new Coordinate(i, j)));
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}

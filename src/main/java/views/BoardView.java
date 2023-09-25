package views;
import model.*;

public class BoardView {
    public void write(Game game) {
        Message.HORIZONTAL_LINE.writeln();
        for (int i = 0; i < Board.NUM_ROWS; i++) {
            Message.VERTICAL_LINE.write();
            for (int j = 0; j < Board.NUM_COLUMNS; j++) {
                new TokenView().write(game.getToken(new Coordinate(i, j)));
                Message.VERTICAL_LINE.write();
            }
            System.out.println(); // Valorar poner clase console
        }
        Message.HORIZONTAL_LINE.writeln();
    }
}

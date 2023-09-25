package views;
import model.*;

import java.util.Scanner;

public class PlayerView extends GameView {
    PlayerView(Game game) {
        super(game);
    }

    public void interact() {
        Scanner scanner = new Scanner(System.in);
        int column;
        do {
            Message.DROP_TOKEN.writeln();
            column = scanner.nextInt();
        } while (!this.game.enableColumn(column));

        this.game.dropPiece(column);
    }
}

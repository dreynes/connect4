package views;
import model.*;
public class PlayView extends GameView{
    public PlayView(Game game) {
        super(game);
    }

    public void interact() {
        do {
            new PlayerView(this.game).interact();
            this.game.switchPlayersTurn();
            new BoardView().write(this.game);
        } while (!this.checkConnect4() && !this.isBoardFull());
    }

    public boolean checkConnect4() {
        boolean out = this.game.checkConnect4();
        if (out) {
            Message.WIN.writeln(this.game.getActiveToken());
        }
        return out;
    }

    public boolean isBoardFull() {
        boolean out = this.game.isBoardFull();
        if (out) {
            Message.DRAW.writeln();
        }
        return out;
    }
}

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
        } while (!this.game.checkConnect4());
        Message.WIN.writeln(this.game.getActiveTokenName());
    }
}

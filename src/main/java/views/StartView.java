package views;
import model.*;
public class StartView extends GameView {
    public StartView (Game game) {
        super(game);
    }

    public void interact () {
        Message.TITLE.writeln();
        new BoardView().write(this.game);
    }
}

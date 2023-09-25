package views;
import model.*;

abstract class GameView {
    protected Game game;

    GameView(Game game) {
        this.game = game;
    }
}
package model;
import views.View;

public class Connect4 {
    private final Game game;

    private final View view;

    public Connect4() {
        this.game = new Game();
        this.view = new View(this.game);
    }

    public void play() {
        do {
            this.view.start();
            this.view.play();
        } while (this.view.resume());
    }

    public static void main(String[] args) {
        Connect4 connect4 = new Connect4();
        connect4.play();
    }
}
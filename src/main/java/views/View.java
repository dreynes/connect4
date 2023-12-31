package views;
import model.*;

public class View extends GameView {
    private final StartView startView;
    private final PlayView playView;
    private final ResumeView resumeView;
    public View(Game game) {
        super(game);
        this.startView = new StartView(game);
        this.playView = new PlayView(game);
        this.resumeView = new ResumeView(game);
    }

    public void start() {
        this.startView.interact();
    }
    public void play() {
        this.playView.interact();
    }
    public boolean resume() {
        return this.resumeView.interact();
    }
}

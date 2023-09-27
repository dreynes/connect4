package model;

public class Game {
    private Turn turn;
    private Board board;
    public Game () {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public Player getActivePlayer() {
        return this.turn.getActivePlayer();
    }

    public boolean checkConnect4() {
        return this.board.checkVictory(this.getActiveToken());
    }
    public Token getToken(Coordinate coordinate) {
        return this.board.getTokenAt(coordinate);
    }

    public Token getActiveToken() {
        return this.turn.getActiveToken();
    }
    public String getActiveTokenName() {
        return this.turn.getActiveTokenName();
    }
    public boolean enableColumn(int column) {
        return this.board.enableColumn(column);
    }
    public void dropPiece(int column) {
        this.turn.dropPiece(column);
    }
    public void switchPlayersTurn() {
        this.turn.switchPlayersTurn();
    }
    public void reset(){
        turn.reset();
        board.reset();
    }
}

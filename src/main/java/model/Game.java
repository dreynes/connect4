package model;

public class Game {
    private Turn turn;
    private Board board;
    public Game () {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public void putToken(Coordinate coordinate) {
        this.turn.putToken(coordinate);
    }

    public Player getActivePlayer() {
        return this.turn.getActivePlayer();
    }

    public boolean checkConnect4() {
        return this.board.checkConnect4(this.getActivePlayer());
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
    public Coordinate dropPiece(int column) {
        return this.board.dropPiece(column, this.getActiveToken());
    }
    public void switchPlayersTurn() {
        this.turn.switchPlayersTurn();
    }
}

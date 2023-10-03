package model;

public class Game {
    private final Turn turn;
    private final Board board;
    public Game () {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public boolean checkConnect4() {
        return this.board.checkVictory();
    }

    public boolean isBoardFull() {
        return this.board.isBoardFull();
    }

    public Token getToken(Coordinate coordinate) {
        return this.board.getTokenAt(coordinate);
    }

    public Token getActiveToken() {
        return this.turn.getActiveToken();
    }
    public boolean enableColumn(int column) {
        return this.board.enableColumn(column);
    }
    public void putPiece(int column) {
        this.turn.putPiece(column);
    }
    public void switchPlayersTurn() {
        this.turn.switchPlayersTurn();
    }
    public void reset(){
        turn.reset();
        board.reset();
    }
}

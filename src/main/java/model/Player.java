package model;

public class Player {
    private final Token token;
    private final Board board;
    public Player(Token token, Board board) {
        this.board = board;
        this.token = token;
    }

    public void putPiece(int column) {
        this.board.putPiece(column, this.token);
    }
    public Token getToken() {
        return token;
    }

}

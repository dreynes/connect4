package model;

import model.Board;
import model.Token;

public class Player {
    private Token token;
    private Board board;
    public Player(Token token, Board board) {
        this.board = board;
        this.token = token;
    }

    public void dropPiece(int column) {
        this.board.dropPiece(column, this.token);
    }
    public Token getToken() {
        return token;
    }
    public String getTokenName() {
        return token.getTokenName();
    }

}

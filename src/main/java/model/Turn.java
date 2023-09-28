package model;

public class Turn {

    private int value;
    public static final int NUM_PLAYERS = 2;
    private final Player[] players;

    private final Board board;

    public Turn(Board board) {
        this.board = board;
        this.players = new Player[NUM_PLAYERS];
        this.reset();
        this.value = 0;
    }
    public int alternateValue() {
        return (this.value + 1) % Turn.NUM_PLAYERS;
    }

    public void changeValue() {
        this.value = this.alternateValue();
    }


    public Player getActivePlayer() {
        return this.players[value];
    }
    public Token getActiveToken() {
        return this.players[value].getToken();
    }
    public void switchPlayersTurn() {
        if (!this.board.checkVictory()) {
            this.changeValue();
        }
    }
    public void dropPiece(int column){
        this.getActivePlayer().dropPiece(column);
    }
    public void reset(){
        for (int i = 0; i < Turn.NUM_PLAYERS; i++) {
            this.players[i] = new Player(Token.get(i), this.board);
        }
        this.value = 0;
    }
}
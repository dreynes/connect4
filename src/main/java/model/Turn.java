package model;

public class Turn {

    private int value;
    public static final int NUM_PLAYERS = 2;
    private Player[] players;

    private Board board;

    public Turn(Board board) {
        this.board = board;
        players = new Player[NUM_PLAYERS];
        reset();
        value = 0;

    }

    public Player player() {
        return this.players[value];
    }

    public Player previousPlayer() {
        return this.players[alternateValue()];
    }

    public Token previousPlayerToken() {
        return this.previousPlayer().getToken();
    }

    public int alternateValue() {
        return (value + 1) % Turn.NUM_PLAYERS;
    }

    public void changeValue() {
        value = alternateValue();
    }


    public Player getActivePlayer() {
        return players[value];
    }
    public Token getActiveToken() {
        return players[value].getToken();
    }
    public String getActiveTokenName() {
        return players[value].getTokenName();
    }
    public void switchPlayersTurn() {
        if (!this.board.checkVictory(this.getActiveToken())) {
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
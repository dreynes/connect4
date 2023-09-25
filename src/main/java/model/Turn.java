package model;

public class Turn {

    private int value;
    private final int numPlayers = 2;
    private Player[] players;

    private Board board;

    public Turn(Board board) {
        this.board = board;
        players = new Player[numPlayers];
        players[0] = new Player(Token.XS);
        players[1] = new Player('o');
        value = 0;

    }

    public Player player() {
        return players[value];
    }

    public Token playerColor() {
        return players[value].getToken();
    }

    public Player previousPlayer() {
        return players[alternateValue()];
    }

    public Token previousPlayerColor() {
        return previousPlayer().getToken();
    }

    public int alternateValue() {
        return (value + 1) % numPlayers;
    }

    public void changeValue() {
        value = alternateValue();
    }

    // Nuevos metodos
    public Player getActivePlayer() {
        return players[value];
    }
    public Token getActiveToken() {
        return players[value].getToken();
    }
    public String getActiveTokenName() {
        return players[value].getTokenName();
    }
    public void putToken(Coordinate coordinate) {
        this.board.dropPiece(coordinate, this.getActiveToken());
    }
    public void switchPlayersTurn() {
        if (!this.board.checkVictory(this.getActiveToken())) {
            this.changeValue();
        }
    }
}

public class Turn {

    private int value;
    private final int numPlayers = 2;
    private Player[] players;

    public Turn() {
        players = new Player[numPlayers];
        players[0] = new Player('x');
        players[1] = new Player('o');
        value = 0;

    }

    public Player player() {
        return players[value];
    }

    public Token playerColor() {
        return players[value].getColor();
    }

    public Player previousPlayer() {
        return players[alternateValue()];
    }

    public Token previousPlayerColor() {
        return previousPlayer().getColor();
    }

    public int alternateValue() {
        return (value + 1) % numPlayers;
    }

    public void changeValue() {
        value = alternateValue();
    }

}
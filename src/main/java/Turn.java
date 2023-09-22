
public class Turn {

    private int value;

    private Player[] players;

    public Turn() {
        players = new Player[Constant.numPlayers];
        players[0] = new Player('x');
        players[1] = new Player('o');
        value = 0;

    }


    public Token getColor() {
        return players[value].getColor();
    }

    public Token previousPlayerColor() {
        return previousPlayer().getColor();
    }

    public Player getPlayer() {
        return players[value];
    }

    public int alternateValue() {
        return (value + 1) % Constant.numPlayers;
    }

    public Player previousPlayer() {
        return players[alternateValue()];
    }

    public void change() {
        value = alternateValue();
    }

}

public class Turn {

    private int value = 0;

    private Player[] players;

    public Turn() {
        players = new Player[2];
        for(int i=0; i<2; i++){
            players[i] = new Player(i);
        }
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

    public Player previousPlayer() {
        return players[(value +1)% 2];
    }

    public void change() {
        value = (value +1)% 2;
    }

}

public class Player {

    Token color;

    public Player(int i) {
        if (i == 0) {
            color = Token.XS;
        } else {
            color = Token.OS;
        }
    }

    public boolean put(Board board, int column) {
        boolean empty = board.enableColumn(column);
        if(empty)
            return board.dropPiece(column, this.color);
        return false;
    }

    public Token getColor() {
        return color;
    }

}

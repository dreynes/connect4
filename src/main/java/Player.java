
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
        boolean empty = board.eneableColumn(column);
        if(empty)
            return board.dropPiece(column, this.color);
        else {
            System.out.println("Error la columna ya est� llena");
            return false;
        }
    }

    public Token getColor() {
        return color;
    }

}

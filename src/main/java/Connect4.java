import java.util.Scanner;

public class Connect4 {

    private Board board;

    private Turn turn;

    public Connect4() {
        board = new Board();
        turn = new Turn();

    }

    public void play() {
        boolean endGame = false;
        int column;
        Scanner scanner = new Scanner(System.in);
        while(!endGame) {
            board.printBoard();
            Message.Turn.writeln(turn.getColor());
            column = readMove(scanner);
            if(turn.getPlayer().put(board, column)) {
                turn.change();
            }
            if(board.checkVictory(turn.previousPlayerColor())) {
                board.printBoard();
                Message.Win.writeln(turn.previousPlayerColor());
                endGame = true;
            }
            if(board.isBoardFull()) {
                Message.Draws.writeln();
                endGame = true;
            }
        }
        scanner.close();
    }

    public int readMove(Scanner scanner) {

        int column;
        do {
            Message.DropToken.writeln();
            column = scanner.nextInt();
        } while (column < 0 || column > Constant.numColumns-1);

        return column;
    }


    public static void main(String[] args) {
        Connect4 connect4 = new Connect4();
        connect4.play();

    }


}
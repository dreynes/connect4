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
            board.print();
            Message.Turn.writeln(turn.playerColor());
            column = readMove(scanner);
            if(turn.player().put(board, column)) {
                turn.changeValue();
            }
            if(board.checkVictory(turn.previousPlayerColor())) {
                board.print();
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
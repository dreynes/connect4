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
            System.out.println("Turno del Jugador " + turn.getColor().getToken());
            column = readMove(scanner);
            if(turn.getPlayer().put(board, column)) {
                turn.change();
            }
            if(board.checkVictory(turn.getColor())) {
                board.printBoard();
                turn.previousPlayer().victory();
                endGame = true;
            }
            if(board.isBoardFull()) {
                System.out.println("El juego ha terminado en empate.");
                endGame = true;
            }
        }
        scanner.close();
    }


    public int readMove(Scanner scanner) {

        int column;
        do {
            System.out.print("Ingrese la columna (0-6) para colocar su ficha: ");
            column = scanner.nextInt();
        } while (column < 0 || column > 6);

        return column;
    }


    public static void main(String[] args) {
        Connect4 connect4 = new Connect4();
        connect4.play();

    }


}
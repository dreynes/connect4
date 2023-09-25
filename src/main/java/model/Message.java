package model;
public enum Message{

    TURN("Turno del jugador #player"),
    TITLE("Inicio del juego Connec 4"),
    HORIZONTAL_LINE("----------"),
    VERTICAL_LINE("|"),
    DRAWS("La partida ha acabado en empate"),
    WIN("Ha ganado el jugador con las #player"),
    DROP_TOKEN("Ingrese la columna (0-6) para colocar su ficha: ");

    private String message;

    Message(String message) {
        this.message = message;
    }
    public void writeln() {
        System.out.println(this.message);
    }
    public void write() {
        System.out.print(this.message);
    }

    public void writeln(Token player) {
        System.out.println(this.message.replaceAll("#player", "" + player.getTokenName()));
    }
    public void writeln(String player) {
        System.out.println(this.message.replaceAll("#player", player));
    }
}

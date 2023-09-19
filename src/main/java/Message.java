public enum Message{

    Turn("Turno del jugador #player"),
    Draws("La partida ha acabado en empate"),
    Win("Ha ganado el jugador con las #player")

    ;

    private String message;

    Message(String message) {
        this.message = message;
    }
    void writeln() {
        System.out.println(this.message);
    }

    void writeln(Token player) {

        System.out.println(this.message.replaceAll("#player", "" + player.getToken()));
    }

}

package model;
public enum Message{
    RESUME("¿Do you want to repeat?"),
    TURN("Turn of player: #player"),
    TITLE("Connect 4"),
    HORIZONTAL_LINE("----------"),
    VERTICAL_LINE("|"),
    DRAWS("It's been a DRAW."),
    WIN("PLAYER #player WINS!!!"),
    DROP_TOKEN("[#player turn] Choose a column (0-6) to drop your token: ");

    private final String message;

    Message(String message) {
        this.message = message;
    }
    public void writeln() {
        System.out.println(this.message);
    }

    public void writeln(Token player) {
        System.out.println(this.message.replaceAll("#player",  player.getTokenName()));
    }

}

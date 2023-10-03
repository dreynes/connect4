package views;
import model.*;
public class TokenView {
    private final String [] colors = {"\uD83D\uDFE1","\uD83D\uDD34","⬛" };
    void write(Token token) {
        System.out.print(colors[token.ordinal()]);
    }
}

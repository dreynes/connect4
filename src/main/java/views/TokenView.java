package views;
import model.*;
public class TokenView {
    void write(Token token) {
        String string = token.getTokenName();
        if (token.isNone()) {
            string = " ";
        }
        System.out.println(string);
    }
}

package model;

import model.Board;
import model.Token;

public class Player {

    Token token;

    public Player(char piece) {
        if (piece == 'x') {
            token = Token.XS;
        } else {
            token = Token.OS;
        }
    }

    public Player(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }
    public String getTokenName() {
        return token.getTokenName();
    }

}

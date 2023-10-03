package model;

public enum Token {

    XS("YELLOW"),
    OS("RED"),
    NONE("NONE");

    private final String color;

    Token(String color){
        this.color = color;
    }

    public static Token get(int ordinal) {
        assert ordinal >= 0 && ordinal < Token.NONE.ordinal();
        return Token.values()[ordinal];
    }
    public String getColor() {
        return color;
    }
}

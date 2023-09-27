package model;

public enum Token {

    XS("x"),
    OS("o"),
    NONE("-");

    private final String value;

    Token(String value){
        this.value = value;
    }

    public static Token get(int ordinal) {
        assert ordinal >= 0 && ordinal < Token.NONE.ordinal();

        return Token.values()[ordinal];
    }

    public String getTokenName() {
        return value;
    }
    public boolean isNone() {
        return this == NONE;
    }
}

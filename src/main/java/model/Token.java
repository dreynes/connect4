package model;

public enum Token {

    XS("x"),
    OS("o"),
    NONE("-");

    private String value;

    Token(String value){
        this.value = value;
    }

    public String getTokenName() {
        return value;
    }
    public boolean isNone() {
        return this == NONE;
    }
}

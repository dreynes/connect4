
public enum Token {

    XS('x'),
    OS('o'),
    NONE('-');

    private char value;

    Token(char value){
        this.value = value;
    }

    public char getToken() {
        return value;
    }
}

public enum Error {

    OUT_OF_RANGE("Esta columna no existe"),
    COLUMN_FULL("Esta columna está llena");

    private String error;

    Error(String error) {
        this.error = error;
    }
    void writeln() {
        System.out.println(this.error);
    }


}

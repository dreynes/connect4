public enum Error {

    OutOfRange("Esta columna no existe"),
    ColumnFull("Esta columna está llena");

    private String error;

    Error(String error) {
        this.error = error;
    }
    void writeln() {
        System.out.println(this.error);
    }


}

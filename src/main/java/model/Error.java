package model;

public enum Error {

    OUT_OF_RANGE("Row does not exist."),
    COLUMN_FULL("This column is full.");

    private final String error;

    Error(String error) {
        this.error = error;
    }
    void writeln() {
        System.out.println(this.error);
    }
}

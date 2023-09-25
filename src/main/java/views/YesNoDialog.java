package views;


import java.util.Scanner;

public class YesNoDialog {

    private static final char AFFIRMATIVE = 'y';
    private static final char NEGATIVE = 'n';
    private static final String SUFFIX = "? (" +
            YesNoDialog.AFFIRMATIVE+"/" +
            YesNoDialog.NEGATIVE+"): ";
    private static final String MESSAGE = "The value must be '" +
            YesNoDialog.AFFIRMATIVE + "' or '" +
            YesNoDialog.NEGATIVE + "'";
    private String answer;

    public void read(String message) {
        assert message != null;


        boolean ok;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(message);
            this.answer = scanner.nextLine();
            ok = this.isAffirmative() || this.isNegative();
            if (!ok) {
                System.out.println(YesNoDialog.MESSAGE);
            }
        } while (!ok);
    }

    public boolean isAffirmative() {
        return this.getAnswer() == YesNoDialog.AFFIRMATIVE;
    }

    private char getAnswer(){
        return Character.toLowerCase(this.answer.charAt(0));
    }

    public boolean isNegative() {
        return this.getAnswer() == YesNoDialog.NEGATIVE;
    }

}
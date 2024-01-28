package bullscows;

import java.io.IOException;
import java.util.Scanner;

public class InputRequest {

    private int numberLong;
    private int symbolsLong;

    public InputRequest() {
        Scanner scanner = new Scanner(System.in);
        String secretLength = null;
        boolean validInput;
        System.out.println("Input the length of the secret code:");
        do {
            validInput = true;
            try {
                secretLength = scanner.nextLine();
                this.numberLong = Integer.parseInt(secretLength);
            } catch (Exception e) {
                System.out.println("Error: \"" + secretLength + "\" isn't a valid number.");
                validInput = false;
            }
            if (numberLong == 0) {
                System.out.println("error");
                System.exit(0);
            }
            if (numberLong > 36) {
                System.out.println("\"Error: can't generate a secret number with a length of \"" + numberLong + "\" because there aren't enough unique digits.\"");
                validInput = false;
            }

        } while (numberLong > 36 || validInput != true);

    }

    public InputRequest(int numberLong) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number of possible symbols in the code:");
        String symbolLength = null;
        boolean validInput;
        do {
            validInput = true;
            try {
                symbolLength = scanner.nextLine();
                this.symbolsLong = Integer.parseInt(symbolLength);
            } catch (Exception e) {
                System.out.println("Error: \"" + symbolLength + "\" isn't a valid number.");
                validInput = false;
            }
            if (numberLong > symbolsLong) {
                System.out.println("Error: it's not possible to generate a code with a length of " + numberLong + " with " + symbolsLong + " unique symbols.");
                validInput = false;
                System.exit(0);
            } else if (symbolsLong > 36) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                validInput = false;
                System.exit(0);
            }
        } while (symbolsLong > 36 || validInput != true);
    }

    public int getNumberLong() {
        return this.numberLong;
    }

    public int getSymbolsLong() {
        return this.symbolsLong;
    }
}


package bullscows;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Logic {

    private static String userSecret;
    private static int bulls = 0;
    private static int cows = 0;

    public static List<Integer> numberLogic(List<Integer> sequence, int symbolsLong) {
        List<Integer> uniqueNumbers = new ArrayList<>();

        for (Integer num : sequence) {
            if (!uniqueNumbers.contains(num)) {
                uniqueNumbers.add(num);
            } else {
                int newNum;
                do {
                    newNum = new RandomNumber(false, symbolsLong).getRandomNumber();
                } while (uniqueNumbers.contains(newNum));
                uniqueNumbers.add(newNum);
            }
        }
        return uniqueNumbers;
    }

    public static void gameLogic(String sequenceSecret, int numberLong) {
        boolean secretCorrect = false;
        int counter = 1;
        System.out.println("Okay, let's start a game!");
        do {
            System.out.println("Turn " + counter + ":");
            userInput();
            checkSequence(sequenceSecret, userSecret);
            if (bulls == numberLong) {
                secretCorrect = true;
            }
            printAnswer();
            counter++;
        } while (!secretCorrect);
        System.out.println("Congratulations! You guessed the secret code.");
    }

    public static void checkSequence(String secretCode, String userInput) {
        bulls = 0;
        cows = 0;

        // Arrays to track if characters in the secret code
        // have already been counted as bull or cow
        boolean[] secretUsed = new boolean[secretCode.length()];
        boolean[] userUsed = new boolean[userInput.length()];

        // First, find bulls
        for (int i = 0; i < secretCode.length(); i++) {
            if (secretCode.charAt(i) == userInput.charAt(i)) {
                bulls++;
                // Mark these characters as used
                secretUsed[i] = true;
                userUsed[i] = true;
            }
        }
        // Now, find cows
        for (int i = 0; i < secretCode.length(); i++) {
            for (int j = 0; j < userInput.length(); j++) {
                if (!secretUsed[i] && !userUsed[j] && secretCode.charAt(i) == userInput.charAt(j)) {
                    cows++;
                    // Mark these characters as used
                    secretUsed[i] = true;
                    userUsed[j] = true;
                    break; // Exit inner loop after finding a cow
                }
            }
        }
    }

    public static String mixSecretCode(String secretCode, int symbolsLength, int secretCodeLength) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(secretCode);
        if (symbolsLength > 10) {
            RandomLetters randomLetters = new RandomLetters(symbolsLength - 10);
            for (int i = 0; i < random.nextInt(secretCodeLength); i++) {
                stringBuilder.setCharAt(random.nextInt(secretCodeLength), randomLetters.getLetters());
            }
            RandomLetters notRepetitiveLetters = new RandomLetters(stringBuilder);
            StringBuilder temp = new StringBuilder();
            for (char chr : stringBuilder.toString().toCharArray()) {
                if (temp.indexOf(String.valueOf(chr)) == -1) {
                    temp.append(chr);
                } else {
                    char newChar = notRepetitiveLetters.getLetters();
                    temp.append(newChar); // Add new unique character
                }
            }
            stringBuilder = temp;
        }
        return stringBuilder.toString();
    }

    public static void userInput() {
        userSecret = new Scanner(System.in).nextLine();
    }

    public static void printAnswer() {
        System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s).");
    }

    public static void printInformation(int numberLong, int symbolLong) {
        char symbol;
        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < numberLong; i++) {
            stars.append("*");
        }
        if (symbolLong > 0 && symbolLong > 10) {
            symbol = (char) ('a' + (symbolLong - 11));
            System.out.println("The secret is prepared: " + stars + " (0-9, a-" + symbol + ").");
        } else if (symbolLong > 0 && symbolLong <= 10) {
            System.out.println("The secret is prepared: " + stars + " (0-" + (symbolLong - 1) + ").");
        }
    }

}


package bullscows;

import java.util.Random;

public class RandomLetters {
    char letters;

    public RandomLetters(int upperBound) {
        Random random = new Random();
        this.letters = (char) ('a' + random.nextInt(upperBound));
    }

    public RandomLetters(StringBuilder sb) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (sb.indexOf(String.valueOf(ch)) == -1) {
                this.letters = ch;
            }
        }
    }

    public char getLetters() {
        return letters;
    }

}

package bullscows;

import java.util.List;
import java.util.Random;

public class RandomNumber {

    private long randomNumberSeq;

    private long randomNumber;
    private String randomForString;
    protected Random random = new Random();

    public RandomNumber(boolean fullNumber, int symbolsLong) {
        if (fullNumber) {
            this.randomNumberSeq = random.nextLong();
            if (randomNumberSeq < 0) {
                randomNumberSeq *= -1;
            }
        } else if (symbolsLong > 10) {
            this.randomNumber = random.nextInt(10);
        } else {
            this.randomNumber = random.nextInt(symbolsLong);
        }
    }

    public RandomNumber(List<Integer> secretRandom) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i <= secretRandom.size() - 1; i++) {
            temp.append(secretRandom.get(i));
        }
        this.randomForString = temp.toString();
    }

    public int getRandomNumber() {
        return (int) this.randomNumber;
    }

    public String getRandomForString() {
        return this.randomForString;
    }

    public long getRandomNumberSeq() {
        return randomNumberSeq;
    }

}

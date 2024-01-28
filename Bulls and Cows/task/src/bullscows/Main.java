package bullscows;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputRequest secretCode = new InputRequest();
        int numberLong = secretCode.getNumberLong();
        InputRequest symbols = new InputRequest(numberLong);
        int symbolLong = symbols.getSymbolsLong();

        RandomNumber randomNumber = new RandomNumber(true, symbolLong);

        RunNumberSequence runNumberSequence = new RunNumberSequence(numberLong, randomNumber.getRandomNumberSeq());
        List<Integer> secretSeq = runNumberSequence.getSeq();
        RandomNumber randomToString = new RandomNumber(Logic.numberLogic(secretSeq, symbolLong));
        String secretMixed = Logic.mixSecretCode(randomToString.getRandomForString(), symbolLong, numberLong);
        Logic.printInformation(numberLong, symbolLong);
        System.out.println(secretMixed);
        Logic.gameLogic(secretMixed, numberLong);
    }
}

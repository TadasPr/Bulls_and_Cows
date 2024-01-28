package bullscows;

import java.util.ArrayList;
import java.util.List;

public class RunNumberSequence {
    private List<Integer> seq;

    public RunNumberSequence(int numberLong, long numberSeq) {
        this.seq = new ArrayList<Integer>(numberLong);
        long number;
        for (int i = 0; i < numberLong; i++) {
            number = ((numberSeq / (long) Math.pow(10.0, i)) % 10);
            seq.add(seq.size() - i, (int) number);
        }
    }

    public List<Integer> getSeq() {
        return this.seq;
    }
}

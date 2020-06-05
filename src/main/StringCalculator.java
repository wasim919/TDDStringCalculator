package main;

import java.util.List;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

/**
 * Created by wasim on 04-06-2020.
 */
public class StringCalculator {
    private String delimiter;
    public int sum(String s) {
        if (s.length() == 0) {
            return 0;
        }
        List<Integer> numberSequence = getNumberSequence(s);
        checkForNegativeNumbers(numberSequence);
        return numberSequence.stream().reduce(0, (el1, el2) -> el1 + el2);
    }

    private void checkForNegativeNumbers(List<Integer> numberSequence) {
        String negativeNumbers = numberSequence.stream().filter(el -> el<0).map(el -> Integer.toString(el)).collect(Collectors.joining(","));
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negative number: " + negativeNumbers);
        }
    }

    public List<Integer> getNumberSequence(String s) {
        String delimiter;
        if (s.startsWith("//")) {
            String[] headerAndNumberSequence = s.split("\n", 2);
            delimiter = headerAndNumberSequence[0].substring(2);
            s = headerAndNumberSequence[1];
        } else {
            delimiter = ",|\n";
        }
        return Arrays.stream(s.split(delimiter)).map(el -> Integer.parseInt(el.trim())).collect(Collectors.toList());
    }
}

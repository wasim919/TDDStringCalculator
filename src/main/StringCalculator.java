package main;

import javax.security.sasl.SaslServer;
import java.util.*;
import java.lang.reflect.Array;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by wasim on 04-06-2020.
 */
public class StringCalculator {
    private String delimiter;
    public static int count = 0;

    public int Add(String s) {
        if (s.length() == 0) {
            return 0;
        }
        List<String> numberSequence = getNumberSequence(s);
        checkForNegativeNumbers(numberSequence);
        numberSequence = removeNumbersGreaterThan1000(numberSequence);
        count++;
        return numberSequence.stream().mapToInt(Integer::parseInt).reduce(0, (el1, el2) -> el1 + el2);
    }

    private List<String> removeNumbersGreaterThan1000(List<String> numberSequence) {
        return numberSequence.stream().filter(el -> Integer.parseInt(el) <= 1000).collect(Collectors.toList());
    }

    private void checkForNegativeNumbers(List<String> numberSequence) {
        String negativeNumbers = numberSequence.stream().filter(el -> Integer.parseInt(el)<0).map(el -> el).collect(Collectors.joining(","));
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negative number: " + negativeNumbers);
        }
    }

    private String getDelimiter(String delimiterSequence) {
        Set<Character> delimiterSet = new HashSet<>();
        String delimiterString = "";
        for (int i=0;i<delimiterSequence.length();++i) {
            delimiterSet.add(delimiterSequence.charAt(i));
        }
        int i = 0;
        for (Character el:
             delimiterSet) {
            delimiterString+=el;
            ++i;
            if (delimiterSet.size() > 1 && i < delimiterSet.size()) {
                delimiterString+="|";
            }
        }
        if (delimiterString.contains("*")) {
            delimiterString = delimiterString.replace("*", "\\*");
        }
        return delimiterString;
    }

    public List<String> getNumberSequence(String s) {
        String delimiter="";
        if (s.startsWith("//")) {
            String[] headerAndNumberSequence = s.split("\n", 2);
            String delimiterSequence = headerAndNumberSequence[0].substring(2, headerAndNumberSequence[0].length());
            delimiter = getDelimiter(delimiterSequence);
            s = headerAndNumberSequence[1];
        } else {
            delimiter = ",|\n";
        }

        List<String> numberSequence = new ArrayList<String>(Arrays.asList(s.split(delimiter)));
        numberSequence.removeAll(Arrays.asList("", null));
        return numberSequence;
    }

    public int GetCalledCount() {
        return this.count;
    }
}

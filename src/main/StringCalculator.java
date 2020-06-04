package main;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by wasim on 04-06-2020.
 */
public class StringCalculator {
    private String delimiter;
    public int sum(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.startsWith("//")) {
            String[] headerAndNumberSequence = s.split("\n", 2);
            delimiter = headerAndNumberSequence[0].substring(2);
            s = headerAndNumberSequence[1];
        } else {
            delimiter = ",|\n";
        }
        return Arrays.stream(s.split(delimiter)).map(el -> Integer.parseInt(el.trim())).reduce(0, (num1, num2) -> num1 + num2);
    }
}

package main;

import java.awt.*;
import java.util.Arrays;

/**
 * Created by wasim on 04-06-2020.
 */
public class StringCalculator {
    private String match;
    public int sum(String s) {
        if (s.length() == 0) {
            return 0;
        }
        match = ",";
        if (s.contains("\n")) {
            match = ",|\n";
        }
        return Arrays.stream(s.split(match)).map(el -> Integer.parseInt(el.trim())).reduce(0, (num1, num2) -> num1 + num2);
    }
}

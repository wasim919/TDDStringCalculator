package main;

import java.util.Arrays;

/**
 * Created by wasim on 04-06-2020.
 */
public class StringCalculator {
    public int sum(String s) {
        if (s.length() == 0) {
            return 0;
        }
        return Arrays.stream(s.split(",")).map(el -> Integer.parseInt(el.trim())).reduce(0, (num1, num2) -> num1 + num2);
    }
}

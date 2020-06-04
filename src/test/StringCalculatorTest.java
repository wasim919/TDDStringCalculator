package test;

import main.StringCalculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by wasim on 04-06-2020.
 */
public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @Before
    public void init() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void emptyStringSumsTo0() {
        init();
        assertEquals(stringCalculator.sum(""), 0);
    }

    @Test
    public void sumSingleNumber() {
        init();
        assertEquals(stringCalculator.sum("2"), 2);
        assertEquals(stringCalculator.sum("54"), 54);
    }

    @Test
    public void sumTwoNumbersSeperatedByComma() {
        assertEquals(stringCalculator.sum("10, 5"), 15);
    }

    @Test
    public void sumNumberSeperatedByComma() {
        assertEquals(stringCalculator.sum("10, 5, 9, 10"), 34);
    }
}

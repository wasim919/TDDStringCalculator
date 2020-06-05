package test;

import main.StringCalculator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
        assertEquals(stringCalculator.sum(""), 0);
    }

    @Test
    public void sumSingleNumber() {
        assertEquals(stringCalculator.sum("2"), 2);
        assertEquals(stringCalculator.sum("54"), 54);
    }

    @Test
    public void sumTwoNumbersSeparatedByComma() {
        assertEquals(stringCalculator.sum("10, 5"), 15);
    }

    @Test
    public void sumNumberSeparatedByComma() {
        assertEquals(stringCalculator.sum("10, 5, 9, 10"), 34);
    }

    @Test
    public void sumNumbersSeparatedByCommaOrNewLine() {
        assertEquals(stringCalculator.sum("1\n 2, 3"), 6);
    }

    @Test
    public void useDelimiterSpecified() {
        assertEquals(stringCalculator.sum("//;\n1;2"), 3);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwNegativeNumberException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Negative number: -3,-5,-13");

        stringCalculator.sum("1, -3, -5, -13");
    }
}

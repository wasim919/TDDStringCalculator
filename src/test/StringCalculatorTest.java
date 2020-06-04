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
}

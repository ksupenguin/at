package signs;

import base.GenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PositiveTest extends GenericTest {

    @Test
    public void isNumPositiveTest() {
        Assert.assertTrue(calculator.isPositive(1), "Number is not expected to be negative");
        Assert.assertFalse(calculator.isPositive(0), "Number is not expected to be negative");
        Assert.assertFalse(calculator.isPositive(-1), "Number is expected to be negative");
    }

    @org.junit.Test
    public void isNumPositiveTestUnit() {
        assertTrue("Number is not expected to be negative", calculator.isPositive(1));
        assertFalse("Number is not expected to be negative", calculator.isPositive(0));
        assertFalse("Number is expected to be negative", calculator.isPositive(-1));
    }
}

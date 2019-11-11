package signs;

import base.GenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NegativeTest extends GenericTest {

    @Test
    public void isNumNegativeTest() {
        Assert.assertTrue(calculator.isNegative(-1), "Number is not expected to be positive");
        Assert.assertFalse(calculator.isNegative(0), "Number is not expected to be positive");
        Assert.assertFalse(calculator.isNegative(1), "Number is expected to be positive");
    }

    @org.junit.Test
    public void isNumNegativeTestUnit() {
        assertFalse("Number is expected to be positive", calculator.isNegative(1));
        assertFalse("Number is expected to be positive", calculator.isNegative(0));
        assertTrue("Number is not expected to be positive", calculator.isNegative(-1));
    }
}

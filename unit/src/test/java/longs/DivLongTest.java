package longs;

import base.GenericTest;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.runner.RunWith;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class DivLongTest extends GenericTest {

    @com.tngtech.java.junit.dataprovider.DataProvider
    @DataProvider(name = "dataProviderForDivLong")
    public static Object[][] testDivLongUnit() {
        return new Object[][]{
                {1, 5, 0},
                {1, 1, 1},
                {5, 1, 5},
                {3, 3, 1},
                {Long.MAX_VALUE, Long.MAX_VALUE, 1},
                {0, -1, 0},
                {0, 1, 0},
                {-1, -5, 0},
                {-1, -1, 1},
                {-8, -2, 4},
                {-1, 1, -1},
                {-4, 2, -2},
                {3, -1, -3},
        };
    }

    @Test(dataProvider = "dataProviderForDivLong")
    public void testDiv(long a, long b, long expected) {
        long res = calculator.div(a, b);
        Assert.assertEquals(res, expected, "Wrong result of div, expected: " + expected);
    }

    @org.junit.Test
    @UseDataProvider()
    public void testDivLongUnit(long a, long b, long expected) {
        long res = calculator.div(a, b);
        assertEquals("Wrong result of div, expected: " + expected, expected, res);
    }

    @Test(expectedExceptions = {NumberFormatException.class})
    public void testDivByZero() {
        Assert.assertEquals(calculator.div(1, 0), 0);
        Assert.assertEquals(calculator.div(0, 0), 0);
        Assert.assertEquals(calculator.div(-1, 0), 0);
    }

    @Parameters({"a", "b", "div"})
    @Test(groups = "divZero")
    public void testDivWithZeroXml(long a, long b, long div) {
        Assert.assertEquals(calculator.div(a, b), div);
    }
}

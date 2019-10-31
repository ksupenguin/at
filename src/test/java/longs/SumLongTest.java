package longs;

import base.GenericTest;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.runner.RunWith;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class SumLongTest extends GenericTest {

    @com.tngtech.java.junit.dataprovider.DataProvider
    @DataProvider(name = "dataProviderForSumLong")
    public static Object[][] testSumPositiveUnit() {
        return new Object[][]{
                {1, 5, 6},
                {3, 1, 4},
                {Long.MAX_VALUE, Long.MAX_VALUE, 2 * Long.MAX_VALUE},
                {1, 0, 1},
                {0, 1, 1},
                {0, 0, 0},
                {-1, 0, -1},
                {0, -1, -1},
                {-1, -1, -2},
                {-1, -5, -6},
                {-7, -2, -9},
                {-999999999, -999999999, -1999999998},
                {Long.MIN_VALUE, Long.MIN_VALUE, 2 * Long.MIN_VALUE},
                {-1, 1, 0},
                {-2, 3, 1},
                {-3, 2, -1},
                {-999999999, 999999999, 0}
        };
    }

    @Test(dataProvider = "dataProviderForSumLong")
    public void testSumPositive(long a, long b, long expected) {
        long res = calculator.sum(a, b);
        Assert.assertEquals(res, expected, "Wrong result of sum, expected: " + expected);
    }

    @org.junit.Test
    @UseDataProvider("testSumPositiveUnit")
    public void testSumPositiveUnit(long a, long b, long expected) {
        long res = calculator.sum(a, b);
        assertEquals("Wrong result of sum, expected: " + expected, expected, res);
    }
}

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
public class SubLongTest extends GenericTest {

    @com.tngtech.java.junit.dataprovider.DataProvider
    @DataProvider(name = "dataProviderForSubLong")
    public static Object[][] testSubLongUnit() {
        return new Object[][]{
                {5, 5, 0},
                {3, 1, 2},
                {3, 4, -1},
                {Long.MAX_VALUE, Long.MAX_VALUE, 0},
                {1, 0, 1},
                {0, 1, -1},
                {0, 0, 0},
                {-1, 0, -1},
                {0, -1, 1},
                {-1, -1, 0},
                {-1, -5, 4},
                {-7, -2, -5},
                {-999999999, -999999999, 0},
                {Long.MIN_VALUE, Long.MIN_VALUE, 0},
                {-1, 1, -2},
                {-2, 3, -5},
                {-3, 2, -5},
        };
    }

    @Test(dataProvider = "dataProviderForSubLong")
    public void testSubPositive(long a, long b, long expected) {
        Assert.assertEquals(calculator.sub(a, b), expected, "Wrong result of sub, expected: " + expected);
    }

    @org.junit.Test
    @UseDataProvider("testSubLongUnit")
    public void testSumPositiveUnit(long a, long b, long expected) {
        long res = calculator.sub(a, b);
        assertEquals("Wrong result of sub, expected: " + expected, expected, res);
    }
}

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
public class MultLongTest extends GenericTest {

    @com.tngtech.java.junit.dataprovider.DataProvider
    @DataProvider(name = "testMultLongUnit")
    public static Object[][] testMultLongUnit() {
        return new Object[][]{
                {1, 5, 5},
                {1, 1, 1},
                {5, 1, 5},
                {3, 3, 9},
                {Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE * Long.MAX_VALUE},
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
                {-1, 0, 0},
                {0, -1, 0},
                {-1, -1, 1},
                {-1, -5, 5},
                {-7, -2, 14},
                {-1, 1, -1},
                {-2, 3, -6},
                {-3, 2, -6},
        };
    }

    @Test(dataProvider = "testMultLongUnit")
    public void testMultPositive(long a, long b, long expected) {
        long res = calculator.mult(a, b);
        Assert.assertEquals(res, expected, "Wrong result of mult, expected: " + expected);
    }

    @org.junit.Test
    @UseDataProvider("testMultLongUnit")
    public void testMultLongUnit(long a, long b, long expected) {
        long res = calculator.mult(a, b);
        assertEquals("Wrong result of mult, expected: " + expected, expected, res);
    }
}

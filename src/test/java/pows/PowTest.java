package pows;

import base.GenericTest;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.runner.RunWith;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class PowTest extends GenericTest {

    @com.tngtech.java.junit.dataprovider.DataProvider
    @DataProvider(name = "testPowDoubleUnit")
    public static Object[][] testPowDoubleUnit() {
        return new Object[][]{
                {1.00, 1.00, 1.00},
                {1.00, Double.MAX_VALUE, 1.00},
                {2.00, 1.00, 2.00},
                {2.00, 2.00, 4.00},
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE * Double.MAX_VALUE},
                {4.00, 0.5, 2.00},
                {0.5, 2.00, 0.25},
                {1.00, -1.00, 1.00},
                {1.00, Double.MIN_VALUE, 1.00},
                {2.00, -1.00, 0.5},
                {2.00, -2.00, 0.25},
                {Double.MAX_VALUE, -Double.MAX_VALUE, 0},
                {4.00, -0.5, 0.5},
                {0.5, -2.0, 4.0},
                {-1, -1, -1},
                {-1, Double.MIN_VALUE, 1},
                {-2, -1, -0.5},
                {-2, -2, -0.25},
                {-Double.MAX_VALUE, -Double.MAX_VALUE, 0},
                {-4, -0.5, -0.5},
                {-0.5, -2, -4},
                {-1, 1, -1},
                {-1, Double.MIN_VALUE, 1},
                {-2, 1, -2},
                {-2, 2, 4},
                {-Double.MAX_VALUE, Double.MAX_VALUE, 0},
                {-4, 0.5, -2},
                {-0.5, 2, -0.25},
                {-1, 0, 1},
                {1, 0, 1},
                {2, 0, 1},
                {-2, 0, 1},
                {-Double.MAX_VALUE, 0, 1},
                {Double.MAX_VALUE, 0, 1},
                {-4, 0, 1},
                {-0.5, 0, 1},
        };
    }

    @Test(dataProvider = "testPowDoubleUnit")
    public void testPow(double a, double b, double expected) {
        double res = calculator.pow(a, b);
        Assert.assertEquals(res, expected, "Wrong result of pow, expected: " + expected);
    }

    @org.junit.Test
    @UseDataProvider("testPowDoubleUnit")
    public void testPowDoubleUnit(double a, double b, Double expected) {
        Double res = calculator.pow(a, b);
        assertEquals("Wrong result of pow, expected: " + expected, expected, res);
    }
}

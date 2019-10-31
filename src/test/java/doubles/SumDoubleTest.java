package doubles;

import base.GenericTest;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.runner.RunWith;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class SumDoubleTest extends GenericTest {

    @com.tngtech.java.junit.dataprovider.DataProvider
    @DataProvider(name = "dataProviderForSumDouble")
    public static Object[][] testSumDoubleUnit() {
        return new Object[][]{
                {1.1, 5.0, 6.1},
                {3.0, 1.001, 4.001},
                {Double.MAX_VALUE, Double.MAX_VALUE, 2 * Double.MAX_VALUE},
                {1.999, 0.00, 1.999},
                {0.00, 1.1, 1.1},
                {0.00, 0.00, 0.00},
                {-1.1, 0, -1.1},
                {0.00, -1.9, -1.9},
                {-1.000, -1.000, -2.00},
                {-1.5, -5.5, -7.00},
                {-7.1, -2.9, -10.00},
                {-0.999999999, -0.999999999, -1.999999998},
                {-1.1, 1.1, 0.00},
                {-2.9, 3.1, 0.2},
                {-3.1, 2.9, -0.2},
                {-0.999999999, 0.999999999, 0.00}
        };
    }

    @Test(dataProvider = "dataProviderForSumDouble")
    public void testSumPositive(double a, double b, double expected) {
        double res = GenericTest.calculator.sum(a, b);
        Assert.assertEquals(res, expected, "Wrong result of sum, expected: " + expected);
    }

    @org.junit.Test
    @UseDataProvider("testSumDoubleUnit")
    public void testSumPositiveUnit(double a, double b, Double expected) {
        Double res = GenericTest.calculator.sum(a, b);
        assertEquals("Wrong result of sum, expected: " + expected, expected, res);
    }
}

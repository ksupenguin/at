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
public class SubDoubleTest extends GenericTest {

    @com.tngtech.java.junit.dataprovider.DataProvider
    @DataProvider(name = "dataProviderForSubDouble")
    public static Object[][] testSubDoubleUnit() {
        return new Object[][]{
                {1.1, 5.0, -3.9},
                {3.0, 1.001, 1.999},
                {Double.MAX_VALUE, Double.MAX_VALUE, 0.0},
                {1.999, 0.00, 1.999},
                {0.0, 1.1, -1.1},
                {0.0, 0.0, 0.0},
                {-1.1, 0.0, -1.1},
                {0.0, -1.9, 1.9},
                {-1.000, -1.000, 0.0},
                {-1.5, -5.5, 4.0},
                {-7.1, -2.9, -4.2},
                {-0.999999999, -0.999999999, 0.0},
                {-1.1, 1.1, -2.2},
                {-2.9, 3.1, -6.0},
                {-3.1, 2.9, -6.0},
        };
    }

    @Test(dataProvider = "dataProviderForSubDouble")
    public void testSubPositive(double a, double b, double expected) {
        double res = GenericTest.calculator.sub(a, b);
        Assert.assertEquals(res, expected, "Wrong result of sub, expected: " + expected);
    }

    @org.junit.Test
    @UseDataProvider("testSubDoubleUnit")
    public void testSubDoubleUnit(double a, double b, Double expected) {
        Double res = GenericTest.calculator.sub(a, b);
        assertEquals("Wrong result of sub, expected: " + expected, expected, res);
    }
}

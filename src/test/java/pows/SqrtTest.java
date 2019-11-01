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
public class SqrtTest extends GenericTest {

    @com.tngtech.java.junit.dataprovider.DataProvider
    @DataProvider(name = "testSqrtUnit")
    public static Object[][] testSqrtUnit() {
        return new Object[][]{
                {4.00, 2.00},
                {1.00, 1.00},
                {3.00, 1.7320508075688772},
                {0.00, 0.00},
                {-1.000, -1.00},
        };
    }

    @Test(dataProvider = "testSqrtUnit")
    public void testSqrtPositive(double a, double expected) {
        double res = calculator.sqrt(a);
        Assert.assertEquals(res, expected, "Wrong result of sqrt, expected: " + expected);
    }

    @org.junit.Test
    @UseDataProvider("testSqrtUnit")
    public void testSqrtUnit(double a, Double expected) {
        Double res = calculator.sqrt(a);
        assertEquals("Wrong result of sqrt, expected: " + expected, expected, res);
    }
}

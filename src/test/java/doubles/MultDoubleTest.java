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
public class MultDoubleTest extends GenericTest {

    @com.tngtech.java.junit.dataprovider.DataProvider
    @DataProvider(name = "testMultDoubleUnit")
    public static Object[][] testMultDoubleUnit() {
        return new Object[][]{
                {1.1, 5.0, 5.5},
                {3.0, 1.001, 3.003},
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE * Double.MAX_VALUE},
                {1.999, 0.00, 0.0},
                {0.0, 1.1, 0.0},
                {0.0, 0.0, 0.0},
                {-1.1, 0.0, 0.0},
                {0.0, -1.9, 0.0},
                {-1.000, -1.000, 1.0},
                {-1.5, -5.5, 8.25},
                {-7.1, -2.9, 20.59},
                {-1.1, 1.1, -1.21},
                {-2.9, 3.1, -8.99},
                {-3.1, 2.9, -8.99},
        };
    }

    @Test(dataProvider = "testMultDoubleUnit")
    public void testMult(double a, double b, double expected) {
        double res = GenericTest.calculator.mult(a, b);
        Assert.assertEquals(res, expected, "Wrong result of mult, expected: " + expected);
    }

    @org.junit.Test
    @UseDataProvider("testMultDoubleUnit")
    public void testMultDoubleUnit(double a, double b, Double expected) {
        Double res = GenericTest.calculator.mult(a, b);
        assertEquals("Wrong result of mult, expected: " + expected, expected, res);
    }
}

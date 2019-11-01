package trigonomerty;

import base.GenericTest;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.runner.RunWith;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class CosTest extends GenericTest {

    @com.tngtech.java.junit.dataprovider.DataProvider
    @DataProvider(name = "testCosUnit")
    public static Object[][] testCosUnit() {
        return new Object[][]{
                {3 * Math.PI / 2, 0.0},
                {Math.PI / 2, 0.0},
                {Math.PI / 3, 0.5},
                {Math.PI, -1.0},
                {2 * Math.PI, 1.0},
                {0.0, 1.0},
        };
    }

    @Test(groups = "trigonometry", dataProvider = "testCosUnit")
    public void calcCosTest(double a, double expected) {
        double res = calculator.cos(a);
        Assert.assertEquals(res, expected, "Wrong result of cos, expected: " + expected);
    }

    @org.junit.Test
    @UseDataProvider("testCosUnit")
    public void testCosUnit(double a, Double expected) {
        Double res = calculator.cos(a);
        assertEquals("Wrong result of cos, expected: " + expected, expected, res);
    }
}

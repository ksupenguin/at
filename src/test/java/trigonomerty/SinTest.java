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
public class SinTest extends GenericTest {

    @com.tngtech.java.junit.dataprovider.DataProvider
    @DataProvider(name = "testSinUnit")
    public static Object[][] testSinUnit() {
        return new Object[][]{
                {Math.PI, 0.0},
                {0.0, 0.0},
                {2 * Math.PI, 0.0},
                {3 * Math.PI / 2, -1.0},
                {Math.PI / 2, 1.0},
                {Math.PI / 6, 0.5}
        };
    }

    @Test(groups = "trigonometry", dataProvider = "testSinUnit")
    public void calcSinTest(double a, double expected) {
        double res = calculator.sin(a);
        Assert.assertEquals(res, expected, "Wrong result of sin, expected: " + expected);
    }

    @org.junit.Test
    @UseDataProvider("testSinUnit")
    public void testSinUnit(double a, Double expected) {
        Double res = calculator.sin(a);
        assertEquals("Wrong result of sin, expected: " + expected, expected, res);
    }
}

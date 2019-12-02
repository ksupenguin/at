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
public class CtgTest extends GenericTest {

    @com.tngtech.java.junit.dataprovider.DataProvider
    @DataProvider(name = "testCtgUnit")
    public static Object[][] testCtgUnit() {
        return new Object[][]{
                {Math.PI / 4, 1.0},
                {3 * Math.PI / 2, 0.0},
                {Math.PI / 2, 0.0},
        };
    }

    @Test(groups = "trigonometry", dataProvider = "testCtgUnit")
    public void calcCtgTest(double a, double expected) {
        double res = calculator.ctg(a);
        Assert.assertEquals(res, expected, "Wrong result of ctg, expected: " + expected);
    }

    @org.junit.Test
    @UseDataProvider("testCtgUnit")
    public void testCtgUnit(double a, Double expected) {
        Double res = calculator.ctg(a);
        assertEquals("Wrong result of ctg, expected: " + expected, expected, res);
    }
}

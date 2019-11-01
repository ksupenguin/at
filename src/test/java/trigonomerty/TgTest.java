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
public class TgTest extends GenericTest {

    @com.tngtech.java.junit.dataprovider.DataProvider
    @DataProvider(name = "testTgUnit")
    public static Object[][] testTgUnit() {
        return new Object[][]{
                {Math.PI / 4, 1.0},
                {Math.PI, 0.0},
                {0.0, 0.0},
                {2 * Math.PI, 0.0}
        };
    }

    @Test(groups = "trigonometry", dataProvider = "testTgUnit")
    public void calcTgTest(double a, double expected) {
        double res = calculator.tg(a);
        Assert.assertEquals(res, expected, "Wrong result of tg, expected: " + expected);
    }

    @org.junit.Test
    @UseDataProvider("testTgUnit")
    public void testTgUnit(double a, Double expected) {
        Double res = calculator.tg(a);
        assertEquals("Wrong result of tg, expected: " + expected, expected, res);
    }
}

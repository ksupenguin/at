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
public class DivDoubleTest extends GenericTest {

    @com.tngtech.java.junit.dataprovider.DataProvider
    @DataProvider(name = "testDivDoubleUnit")
    public static Object[][] testDivDoubleUnit() {
        return new Object[][]{
                {1.1, 5.0, 0.22},
                {3.0, 1.001, 2.997002997002997},
                {Double.MAX_VALUE, Double.MAX_VALUE, 1.00},
                {1.999, 0.00, 0.00},
                {1.999, 0.00, 0.00},
                {0.00, 1.1, 0.00},
                {0.0, 0.0, 0.00},
                {-1.1, 0.00, 0.00},
                {0.00, -1.9, 0.00},
                {-1.000, -1.000, 1.00},
                {-1.5, -5.5, 0.2727272727272727},
                {-7.1, -2.9, 2.4482758620689653},
                {-1.1, 1.1, -1.00},
                {-2.9, 3.1, -0.9354838709677419},
                {-3.1, 2.9, -1.0689655172413794},
        };
    }

    @Test(dataProvider = "testDivDoubleUnit")
    public void testDiv(double a, double b, double expected) {
        double res = GenericTest.calculator.div(a, b);
        Assert.assertEquals(res, expected, "Wrong result of div, expected: " + expected);
    }

    @org.junit.Test
    @UseDataProvider("testDivDoubleUnit")
    public void testDivDoubleUnit(double a, double b, Double expected) {
        Double res = GenericTest.calculator.div(a, b);
        assertEquals("Wrong result of div, expected: " + expected, expected, res);
    }
}
        
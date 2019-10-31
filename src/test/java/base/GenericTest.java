package base;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class GenericTest {

    public static Calculator calculator;

    @org.junit.BeforeClass
    @BeforeClass(alwaysRun = true)
    public static void createCalc() {
        calculator = new Calculator();
    }

    @org.junit.AfterClass
    @AfterClass(alwaysRun = true)
    public static void reset() {
        calculator = null;
    }
}

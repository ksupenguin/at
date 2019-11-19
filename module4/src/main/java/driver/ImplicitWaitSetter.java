package driver;

import org.openqa.selenium.WebDriver;
import waiters.ElementWaiter;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitSetter {

    public static void setImplicitlyWaitTimeout(WebDriver driver, int sec) {
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }

    public static void resetImplicitlyWaitTimeout(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(ElementWaiter.getElementTimeout(), TimeUnit.SECONDS);
    }
}

package driver;

import org.openqa.selenium.WebDriver;
import waiters.ElementWaiter;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(DriverFactory.getDriver());
        }
        return driver.get();
    }

    public static void quit() {
        if (driver.get() != null) {
            getDriver().quit();
            driver.remove();
        }
    }

    public static void setImplicitlyWaitTimeout(int sec) {
        driver.get().manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }

    public static void resetImplicitlyWaitTimeout() {
        driver.get().manage().timeouts().implicitlyWait(ElementWaiter.getElementTimeout(), TimeUnit.SECONDS);
    }
}

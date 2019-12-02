package driver;

import org.openqa.selenium.WebDriver;

public class Driver {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(DriverFactoryImpl.getDriver());
        }
        return driver.get();
    }

    public static void quit() {
        if (driver.get() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}

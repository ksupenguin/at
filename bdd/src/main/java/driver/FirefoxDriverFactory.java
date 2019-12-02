package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import reporter.Reporter;

public class FirefoxDriverFactory implements DriverFactory {

    @Override
    public WebDriver getDriver() {
        WebDriverManager.firefoxdriver().setup();
        Reporter.debug("New Firefox is started");
        return new FirefoxDriver();
    }
}

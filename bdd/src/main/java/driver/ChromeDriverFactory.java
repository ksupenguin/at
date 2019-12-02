package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import reporter.Reporter;

public class ChromeDriverFactory implements DriverFactory {

    @Override
    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        Reporter.debug("New Chrome is started");
        return new ChromeDriver(new ChromeOptions().addArguments("start-maximized").addArguments("--incognito"));
    }
}

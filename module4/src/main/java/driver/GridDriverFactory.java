package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import reporter.Reporter;

import java.net.MalformedURLException;
import java.net.URL;

public class GridDriverFactory implements DriverFactory {

    @Override
    public WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions().addArguments("--start-maximized");

        try {
            return new RemoteWebDriver(new URL("http://10.11.13.120:4444/wd/hub"),
                    options);
        } catch (MalformedURLException err) {
            Reporter.error("Grid URL is malformed: " + "http://10.11.13.120:4444/wd/hub");
            err.printStackTrace();
            return null;
        }
    }
}

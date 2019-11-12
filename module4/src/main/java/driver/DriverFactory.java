package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import reporter.Reporter;

import java.net.MalformedURLException;
import java.net.URL;

class DriverFactory {

    private DriverFactory() {
    }

    static WebDriver getDriver() {
        String platform = System.getProperty("platform");

        switch (platform) {
            case "chrome":
                return getChrome();
            case "ff":
                return getFireFox();
            case "edge":
                return getEdge();
            case "grid":
                return getGrid();
            default:
                throw new IllegalStateException("Platform is not specified");
        }
    }

    private static WebDriver getChrome() {
        WebDriverManager.chromedriver().setup();
        Reporter.debug("New Chrome is started");
        return new ChromeDriver(new ChromeOptions().addArguments("start-maximized"));
    }

    private static WebDriver getFireFox() {
        WebDriverManager.firefoxdriver().setup();
        Reporter.debug("New Firefox is started");
        return new FirefoxDriver();
    }

    private static WebDriver getEdge() {
        WebDriverManager.edgedriver().setup();
        Reporter.debug("New Edge is started");
        return new EdgeDriver();
    }

    private static WebDriver getGrid() {
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

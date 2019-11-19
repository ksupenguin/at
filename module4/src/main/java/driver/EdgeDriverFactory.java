package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import reporter.Reporter;

public class EdgeDriverFactory implements DriverFactory {

    @Override
    public WebDriver getDriver() {
        WebDriverManager.edgedriver().setup();
        Reporter.debug("New Edge is started");
        return new EdgeDriver();
    }
}

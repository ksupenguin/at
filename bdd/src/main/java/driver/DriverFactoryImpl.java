package driver;

import org.openqa.selenium.WebDriver;

class DriverFactoryImpl {

    private DriverFactoryImpl() {
    }

    static WebDriver getDriver() {
        String platform = System.getProperty("platform");

        switch (platform) {
            case "chrome":
                return new ChromeDriverFactory().getDriver();
            case "ff":
                return new FirefoxDriverFactory().getDriver();
            case "edge":
                return new EdgeDriverFactory().getDriver();
            case "grid":
                return new GridDriverFactory().getDriver();
            default:
                throw new IllegalStateException("Platform is not specified");
        }
    }
}

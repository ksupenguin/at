package reporter;

import driver.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Reporter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Reporter.class.getSimpleName());

    private Reporter() {
    }

    public static void debug(String message) {
        LOGGER.debug(message);
    }

    public static void info(String message) {
        LOGGER.info(message);
    }

    public static void error(String message) {
        LOGGER.error(message);
    }

    public static void createScreenshot() {
        File screen = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screen, new File("C:\\Users\\Kseniia_Glushkova\\Downloads\\AT_Mentoring\\screenshot.png"));
            Reporter.info("Screenshot is saved");
        } catch (IOException e) {
            e.printStackTrace();
            Reporter.error("Cannot create screenshot");
        }
    }
}

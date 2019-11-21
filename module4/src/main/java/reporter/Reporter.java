package reporter;

import driver.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

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
            info("Screenshot is saved");
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            String message = "RP_MESSAGE#BASE64#" + new String(Base64.getEncoder().encode(screenshot)) + "#SCREENSHOT";
            error(message);

            byte[] foo = Files.readAllBytes(new File("C:\\Users\\Kseniia_Glushkova\\Downloads\\AT_Mentoring\\screenshot.png").toPath());
            String messag1e = "RP_MESSAGE#BASE64#" + new String(Base64.getEncoder().encode(foo)) + "#SCREENSHOT";
            error(messag1e);
//            ReportPortal.emitLog("Screenshot: ", "error", Calendar.getInstance().getTime(), screen);
        } catch (IOException e) {
            e.printStackTrace();
            error("Cannot create screenshot");
        }
    }
}

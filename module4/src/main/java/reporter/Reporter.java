package reporter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}

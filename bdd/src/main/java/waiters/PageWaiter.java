package waiters;

import driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import reporter.Reporter;

public class PageWaiter {

    private static final long PAGE_TIMEOUT = 120;

    private void performWait(ExpectedCondition<?> expectedCondition) {
        FluentWait<WebDriver> wait = new WebDriverWait(Driver.getDriver(), PAGE_TIMEOUT);
        try {
            wait.until(expectedCondition);
        } catch (TimeoutException e) {
            Reporter.error(String.format("Waiting timeout: expected condition [%s] is not satisfied",
                    expectedCondition.toString()));
        }
    }

    public void urlToContain(String text) {
        performWait(ExpectedConditions.urlContains(text));
    }

    public void pageIsLoaded() {
        Reporter.info("Waiting for page to be loaded");
        new WebDriverWait(Driver.getDriver(), PAGE_TIMEOUT).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}

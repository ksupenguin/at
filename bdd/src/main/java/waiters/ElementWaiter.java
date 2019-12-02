package waiters;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import reporter.Reporter;

public class ElementWaiter {

    private static final long ELEMENT_TIMEOUT = 30;
    private By locator;

    public ElementWaiter(By locator) {
        this.locator = locator;
    }

    public static long getElementTimeout() {
        return ELEMENT_TIMEOUT;
    }

    private void performWait(ExpectedCondition<?> expectedCondition) {
        FluentWait<WebDriver> wait = new WebDriverWait(Driver.getDriver(), ELEMENT_TIMEOUT);
        try {
            wait.until(expectedCondition);
        } catch (TimeoutException e) {
            Reporter.error(String.format("Waiting timeout: expected condition [%s] is not satisfied",
                    expectedCondition.toString()));
        }
    }

    public void visibility() {
        performWait(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickability() {
        performWait(ExpectedConditions.elementToBeClickable(locator));
    }
}

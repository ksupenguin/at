package ui;

import driver.Driver;
import enums.LocatorType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import reporter.Reporter;
import waiters.ElementWaiter;

import java.util.List;

public abstract class AbstractElement<T> {

    private String locatorTemplate;
    private String locatorString;
    private LocatorType locatorType;

    AbstractElement(String locatorString, LocatorType locatorType) {
        this.locatorString = locatorString;
        this.locatorType = locatorType;
    }

    public WebElement findElement() {
        highlightElement();
        return Driver.getDriver().findElement(getLocator());
    }

    private By getLocator() {
        switch (locatorType) {
            case XPATH:
                return By.xpath(locatorString);
            case ID:
                return By.id(locatorString);
            case CSS:
                return By.cssSelector(locatorString);
            case NAME:
                return By.name(locatorString);
            default:
                return null;
        }
    }

    public ElementWaiter waitFor() {
        return new ElementWaiter(getLocator());
    }

    public void click() {
        Reporter.debug("Clicking element");
        waitFor().visibility();
        findElement().click();
    }

    public T formatLocator(String... args) {
        if (locatorTemplate == null) {
            locatorTemplate = locatorString;
        }
        locatorString = String.format(locatorTemplate, args);
        return (T) this;
    }

    private synchronized void highlightElement() {
        if (Boolean.parseBoolean(System.getProperty("highlight"))) {
            Reporter.debug("Highlighting element " + getLocator());

            List<WebElement> webElements = Driver.getDriver().findElements(getLocator());

            if (webElements.size() > 0) {
                WebElement webElement = webElements.get(0);
                String bg = webElement.getCssValue("backgroundColor");
                JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
                js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", webElement);
                try {
                    wait(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", webElement);
            }
        }
    }
}

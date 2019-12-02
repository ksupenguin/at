package ui;

import enums.LocatorType;
import org.openqa.selenium.WebElement;
import reporter.Reporter;

public class Textbox extends AbstractElement<Textbox> {

    public Textbox(String locatorString, LocatorType locatorType) {
        super(locatorString, locatorType);
    }

    public void type(String text) {
        Reporter.debug(String.format("Typing [%s] text into textbox", text));
        waitFor().visibility();
        WebElement webElement = findElement();
        webElement.clear();
        webElement.sendKeys(text);
    }
}

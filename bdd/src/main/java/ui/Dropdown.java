package ui;

import enums.LocatorType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import reporter.Reporter;

import java.util.List;

abstract class Dropdown extends AbstractElement<Dropdown> {

    Dropdown(String locatorString, LocatorType locatorType) {
        super(locatorString, locatorType);
    }

    void selectDdOption(String option, By optionLocator) {
        Reporter.debug(String.format("Choosing [%s] option from dropdown", option));
        waitFor().visibility();

        List<WebElement> options = findElement().findElements(optionLocator);
        for (WebElement opt : options) {
            if (option.equals(opt.getText().trim().replace("\n", " ").trim())) {
                opt.click();
                return;
            }
        }
    }
}

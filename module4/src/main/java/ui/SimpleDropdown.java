package ui;

import enums.LocatorType;
import org.openqa.selenium.By;

public class SimpleDropdown extends Dropdown {

    private static final By OPTION_LOCATOR = By.xpath("//option");

    public SimpleDropdown(String locatorString, LocatorType locatorType) {
        super(locatorString, locatorType);
    }

    public void selectDdOption(String option) {
        selectDdOption(option, OPTION_LOCATOR);
    }
}

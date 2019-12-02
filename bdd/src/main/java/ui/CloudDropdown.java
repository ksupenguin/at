package ui;

import enums.LocatorType;
import org.openqa.selenium.By;

public class CloudDropdown extends Dropdown {

    private static final By OPTION_LOCATOR = By.xpath("//md-option/div[contains(@class, 'md-text')]");

    public CloudDropdown(String locatorString, LocatorType locatorType) {
        super(locatorString, locatorType);
    }

    public void selectDdOption(String option) {
        selectDdOption(option, OPTION_LOCATOR);
    }
}

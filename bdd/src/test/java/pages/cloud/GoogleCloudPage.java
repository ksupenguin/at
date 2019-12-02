package pages.cloud;

import annotations.Locator;
import pages.AbstractPage;
import ui.Button;

public class GoogleCloudPage extends AbstractPage {

    @Locator(xpath = "//a[@track-name = 'exploreSolutions' and contains(text(), 'See all solutions')]")
    public Button seeAllSolutions;

    @Locator(xpath = "//a[@data-label = 'Tab: %s']")
    public Button cloudTab;

    @Locator(xpath = "//a[@track-metadata-eventdetail='calculators']")
    public Button calculatorsLink;
}

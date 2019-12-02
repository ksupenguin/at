package pages.pastebin;

import annotations.Locator;
import pages.AbstractPage;
import ui.Element;

public class OpenedPastePage extends AbstractPage {

    @Locator(css = ".code .paste")
    public Element pasteText;

    @Locator(xpath = "//h1[not(@id = 'title')]")
    public Element pasteTitle;

    @Locator("//p[contains(text(), 'expires')]")
    public Element expirationRow;
}

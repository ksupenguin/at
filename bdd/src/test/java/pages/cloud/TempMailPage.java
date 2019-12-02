package pages.cloud;

import annotations.Locator;
import pages.AbstractPage;
import ui.Element;
import ui.Textbox;

public class TempMailPage extends AbstractPage {

    @Locator(id = "mailAddress")
    public Textbox mailAddress;

    @Locator(xpath = "//span[@class = 'inc-mail-subject']")
    public Element mailSubject;
}

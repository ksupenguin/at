package pages.cloud;

import annotations.Locator;
import pages.AbstractPage;
import ui.Element;
import ui.Textbox;

public class EmailEstimatePage extends AbstractPage {

    @Locator(xpath = "//md-dialog[@aria-label='Email Estiamte']")
    public Element emailWindow;

    @Locator(xpath = "//input[@type = 'email']")
    public Textbox email;
}

package pages.pastebin;

import annotations.Locator;
import pages.AbstractPage;
import ui.Button;
import ui.SimpleDropdown;
import ui.Textbox;

import java.util.HashMap;
import java.util.Map;

public class CreatePastePage extends AbstractPage {

    @Locator(xpath = "//select[@name = 'expiration']")
    public SimpleDropdown expirationDd;
    @Locator(xpath = "//select[@name = 'syntax']")
    public SimpleDropdown syntaxDd;
    @Locator(xpath = "//input[@type = 'submit']")
    public Button createPaste;
    @Locator(id = "id_content")
    private Textbox pasteContent;
    @Locator(id = "id_poster")
    private Textbox pasteName;
    private Map<String, Textbox> textboxMap = new HashMap<>();

    {
        textboxMap.put("Content", pasteContent);
        textboxMap.put("Paste Name / Title", pasteName);
    }

    public Textbox getTextboxByName(String name) {
        return textboxMap.get(name);
    }
}

package pages.yandex;

import annotations.Locator;
import pages.AbstractPage;
import ui.Button;
import ui.Element;

public class InboxPage extends AbstractPage {

    @Locator("//span[text() = 'Входящие']")
    public Button inbox;

    @Locator("//span[contains(@class, 'subject')]/span[@title = '%s']")
    public Element mailWithSubj;

    @Locator("//span[@class='checkbox_view']")
    public Button allCheckbox;

    @Locator("//span[text() = 'Удалить']")
    public Button delete;
}

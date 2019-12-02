package pages.yandex;

import annotations.Locator;
import pages.AbstractPage;
import ui.Button;
import ui.Textbox;

public class NewMailPage extends AbstractPage {

    @Locator("//span[@class='mail-ComposeButton-Text']")
    public Button newMail;

    @Locator("//span[@data-name='Себе']")
    public Button sendMyself;

    @Locator("//input[contains(@name, 'subj')]")
    public Textbox subject;

    @Locator("//span[text() = 'Отправить']")
    public Button send;
}

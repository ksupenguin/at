package pages.yandex;

import annotations.Locator;
import pages.AbstractPage;
import ui.Button;
import ui.Textbox;

public class LoginPage extends AbstractPage {

    @Locator("//a[descendant::span[text() = 'Войти']]")
    public Button mainLogin;

    @Locator("//button[descendant::span[text() = 'Войти']]")
    public Button login;

    @Locator("//input[@name = 'login']")
    public Textbox username;

    @Locator("//input[@name = 'passwd']")
    public Textbox password;
}

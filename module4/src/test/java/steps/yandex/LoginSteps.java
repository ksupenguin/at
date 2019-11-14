package steps.yandex;

import business.User;
import business.UserProvider;
import cucumber.api.java.en.Given;
import pages.yandex.InboxPage;
import pages.yandex.LoginPage;

public class LoginSteps {

    private LoginPage loginPage = new LoginPage();
    private InboxPage inboxPage = new InboxPage();

    @Given("I'm logged in as '(.+)' user")
    public void login(String role) {
        loginPage.waitFor().pageIsLoaded();
        loginPage.mainLogin.click();

        User user = UserProvider.getUser(role);
        loginPage.username.type(user.getLogin());
        loginPage.login.click();
        loginPage.password.type(user.getPassword());
        loginPage.login.click();
        inboxPage.waitFor().pageIsLoaded();
    }
}

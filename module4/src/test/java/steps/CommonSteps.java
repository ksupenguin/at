package steps;

import cucumber.api.java.After;
import driver.Driver;
import pages.yandex.InboxPage;

public class CommonSteps {

    @After(order = 9)
    public void quitBrowser() {
        Driver.quit();
    }

    @After(value = {"@mail"}, order = 10)
    public void deleteMails() {
        InboxPage inboxPage = new InboxPage();
        inboxPage.allCheckbox.click();
        inboxPage.delete.click();
    }
}

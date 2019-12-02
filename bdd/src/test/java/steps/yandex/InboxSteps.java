package steps.yandex;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.yandex.InboxPage;
import reporter.Reporter;
import steps.BrowserSteps;

public class InboxSteps {

    private InboxPage inboxPage = new InboxPage();
    private BrowserSteps browserSteps = new BrowserSteps();

    @When("I open Inbox folder")
    public void openInbox() {
        inboxPage.inbox.click();
    }

    @Then("new email with '(.+)' subject is displayed")
    public void isEmailDisplayed(String subj) {
        browserSteps.refreshPage();
        inboxPage.waitFor().pageIsLoaded();
        Reporter.debug("Checking if mail is here");
        boolean isDisplayed = inboxPage.mailWithSubj.formatLocator(subj).findElement().isDisplayed();
        int i = 0;
        if (!isDisplayed) {
            while (i < 3) {
                browserSteps.refreshPage();
                inboxPage.waitFor().pageIsLoaded();
                isDisplayed = inboxPage.mailWithSubj.formatLocator(subj).findElement().isDisplayed();
                i++;
            }
        }
        Assert.assertTrue("Mail is not displayed", isDisplayed);
    }
}

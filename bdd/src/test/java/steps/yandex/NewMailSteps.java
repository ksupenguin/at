package steps.yandex;

import cucumber.api.java.en.When;
import pages.yandex.NewMailPage;

public class NewMailSteps {

    private NewMailPage newMailPage = new NewMailPage();

    @When("I create a new mail")
    public void createNewMail() {
        newMailPage.newMail.click();
    }

    @When("I choose myself as a recipient")
    public void chooseMyself() {
        newMailPage.sendMyself.click();
    }

    @When("I type '(.+)' subject")
    public void typeSubject(String subj) {
        newMailPage.subject.type(subj);
    }

    @When("I send a mail")
    public void sendMail() {
        newMailPage.send.click();
        newMailPage.waitFor().urlToContain("done");
    }
}

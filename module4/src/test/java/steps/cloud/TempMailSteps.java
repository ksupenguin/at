package steps.cloud;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.Driver;
import driver.ImplicitWaitSetter;
import org.junit.Assert;
import pages.cloud.CloudCalculatorPage;
import pages.cloud.EmailEstimatePage;
import pages.cloud.TempMailPage;
import steps.BrowserSteps;

import java.util.ArrayList;

public class TempMailSteps {

    private TempMailPage tempMailPage = new TempMailPage();
    private BrowserSteps browserSteps = new BrowserSteps();
    private CloudCalculatorPage cloudCalculatorPage = new CloudCalculatorPage();
    private EmailEstimatePage emailEstimatePage = new EmailEstimatePage();

    @When("I copy mail address")
    public void copyMailAddress() throws InterruptedException {
        Driver.getDriver().switchTo().defaultContent();
        browserSteps.switchBrowserTab();
        Driver.getDriver().switchTo().window(new ArrayList<>(Driver.getDriver().getWindowHandles()).get(1));

        String value = getTempEmail();

        browserSteps.returnToBrowserTab("1");
        Driver.getDriver().switchTo().frame(0);

        enterEmail(value);
    }

    private String getTempEmail() {
        tempMailPage.waitFor().pageIsLoaded();
        tempMailPage.mailAddress.waitFor().visibility();
        return tempMailPage.mailAddress.findElement().getAttribute("value");
    }

    private void enterEmail(String mail) throws InterruptedException {
        emailEstimatePage.email.waitFor().visibility();
        emailEstimatePage.email.click();
        Thread.sleep(1000);
        emailEstimatePage.email.type(mail);
    }

    @Then("email with subject '(.+)' is displayed")
    public void isMailDelivered(String subject) {
        ImplicitWaitSetter.setImplicitlyWaitTimeout(Driver.getDriver(), 300);
        tempMailPage.mailSubject.waitFor().visibility();
        ImplicitWaitSetter.resetImplicitlyWaitTimeout(Driver.getDriver());
        Assert.assertEquals(subject, tempMailPage.mailSubject.findElement().getText());
    }

    @When("I open email with subject '(.+)'")
    public void openMailWithSubject(String subj) {
        if (tempMailPage.mailSubject.findElement().getText().equals(subj)) {
            tempMailPage.mailSubject.click();
        }
    }

    @Then("Total Estimated Monthly Cost matches between email and calculator")
    public void compareTotalCost() {
        String total = Driver.getDriver().getPageSource().split("<td><h3>USD ")[1].split("</h3>")[0];
        browserSteps.returnToBrowserTab("1");
        Driver.getDriver().switchTo().frame(0);
        String calcTotal = cloudCalculatorPage.totalSum.findElement().getText().split("USD ")[1].split(" per")[0];
        Assert.assertEquals(calcTotal, total);
    }
}

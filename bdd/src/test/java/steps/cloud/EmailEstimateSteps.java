package steps.cloud;

import cucumber.api.java.en.Then;
import driver.Driver;
import org.junit.Assert;
import pages.cloud.EmailEstimatePage;

public class EmailEstimateSteps {

    private EmailEstimatePage emailEstimatePage = new EmailEstimatePage();

    @Then("Email Your Estimate window is displayed")
    public void isEmailWindowDisplayed() {
        Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().switchTo().frame(0);
        emailEstimatePage.emailWindow.waitFor().visibility();
        Assert.assertTrue("Email window is not displayed", emailEstimatePage.emailWindow.findElement().isDisplayed());
    }
}

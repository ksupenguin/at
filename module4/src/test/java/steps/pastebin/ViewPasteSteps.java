package steps.pastebin;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.pastebin.OpenedPastePage;
import reporter.Reporter;

public class ViewPasteSteps {

    private OpenedPastePage openedPastePage = new OpenedPastePage();

    @Then("paste is posted")
    public void isPastePosted() {
        Reporter.debug("Checking if paste is displayed");
        Assert.assertTrue("Paste page is not displayed", openedPastePage.pasteText.findElement().isDisplayed());
    }

    @Then("page title is \"(.+)\"")
    public void checkPageTitle(String title) {
        String uiTitle = openedPastePage.pasteTitle.findElement().getText();
        Assert.assertTrue(uiTitle + " Page title does not contain " + title, uiTitle.contains(title));
    }

    @Then("entered text is \"(.+)\"")
    public void checkPasteText(String expectedText) {
        String uiText = openedPastePage.pasteText.findElement().getText();
        Assert.assertEquals("Expected and actual paste text are different", expectedText.replace("( +)", "\n"), uiText);
    }
}

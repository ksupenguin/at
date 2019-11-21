package steps.pastebin;

import cucumber.api.java.en.Then;
import enums.ExpirationTime;
import org.junit.Assert;
import pages.pastebin.OpenedPastePage;
import reporter.Reporter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ViewPasteSteps {

    private OpenedPastePage openedPastePage = new OpenedPastePage();

    @Then("paste is posted")
    public void isPastePosted() {
        Reporter.debug("Checking if paste is displayed");
        Assert.assertFalse("Paste page is not displayed", openedPastePage.pasteText.findElement().isDisplayed());
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

    @Then("paste expiration date is calculated correctly for '(.+)' Paste Expiration")
    public void checkExpDate(String expectedExpiration) {
        int expDays = ExpirationTime.getDays(expectedExpiration);
        String uiDay = openedPastePage.expirationRow.findElement().getText().split("on ")[1].replace(".", "");
        String expected = addDaysToCurrentDate(expDays);
        Assert.assertEquals("Wrong number of days is added", expected, uiDay);
    }

    private String addDaysToCurrentDate(int expDays) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(calendar.getTime());
        calendar.add(Calendar.DATE, expDays);
        return dateFormat.format(calendar.getTime());
    }
}

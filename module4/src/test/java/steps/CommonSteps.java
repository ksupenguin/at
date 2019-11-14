package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.yandex.InboxPage;
import reporter.Reporter;

import java.util.ArrayList;

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

    @Given("'(.+)' url is opened")
    public void openUrl(String url) {
        Driver.getDriver().get(url);
    }

    @When("I open '(.+)' url in a new browser tab")
    public void openURLInNewTab(String url) {
        String a = "window.open('" + url + "','_blank');";
        ((JavascriptExecutor) Driver.getDriver()).executeScript(a);
    }

    @When("I return to the '(.+)' browser tab")
    public void returnToBrowserTab(String tabNum) {
        switchBrowserTab();
        Driver.getDriver().switchTo().window(new ArrayList<>(Driver.getDriver().getWindowHandles()).get(Integer.valueOf(tabNum) - 1));
    }

    @When("I refresh page")
    public void refreshPage() {
        Reporter.debug("Refreshing page");
        Driver.getDriver().navigate().refresh();
    }

    public void switchBrowserTab() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.chord(Keys.LEFT_CONTROL, Keys.TAB)).build().perform();
    }
}

package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import driver.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.yandex.InboxPage;
import reporter.Reporter;

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

    @After(order = 11)
    public void createScreen(Scenario scenario) {
        if (scenario.isFailed()) {
            Reporter.createScreenshot();
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }
}

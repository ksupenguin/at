package steps.cloud;

import cucumber.api.java.en.When;
import pages.cloud.GoogleCloudPage;

public class GoogleCloudSteps {

    private GoogleCloudPage googleCloudPage = new GoogleCloudPage();

    @When("I click See all solutions button")
    public void openAllSolutions() {
        googleCloudPage.seeAllSolutions.click();
        googleCloudPage.waitFor().urlToContain("solutions");
    }

    @When("I click '(.+)' tab")
    public void openCloudTab(String tab) {
        googleCloudPage.cloudTab.formatLocator(tab).click();
    }

    @When("I choose Calculators section")
    public void openCalculators() {
        googleCloudPage.calculatorsLink.click();
    }
}

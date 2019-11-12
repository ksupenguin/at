package steps.cloud;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.cloud.CloudCalculatorPage;

public class CloudCalculatorSteps {

    private CloudCalculatorPage cloudCalculatorPage = new CloudCalculatorPage();

    private String vm = "Regular";
    private String instance = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
    private String ssd = "2x375 GB";
    private String datacenter = "Frankfurt (europe-west3)";
    private String usage = "1 Year";

    @Then("Google Cloud Platform Pricing Calculator is opened")
    public synchronized void isCalcOpened() throws InterruptedException {
        String urlPart = "calculator";
        cloudCalculatorPage.waitFor().pageIsLoaded();
        wait(2000);
        Assert.assertTrue("URL does not contain calculator", Driver.getDriver().getCurrentUrl().contains(urlPart));
    }

    @When("I choose '(.+)' calculator tab")
    public void openCalcTab(String tab) {
        Driver.getDriver().switchTo().frame(0);
        cloudCalculatorPage.calcTab.formatLocator(tab).click();
    }

    @When("I fill the form with data")
    public void fillCalcForm() {
        setInstanceCount("4");
        chooseOS("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS");
        chooseVM(vm);
        chooseInstance(instance);
        checkGPUcheckbox();
        selectGpuCount("1");
        chooseGpuType("NVIDIA Tesla V100");
        chooseLocalSsd(ssd);
        chooseDatacenter(datacenter);
        chooseUsage(usage);
    }

    private void chooseUsage(String time) {
        cloudCalculatorPage.usageDropdown.click();
        cloudCalculatorPage.usageDropdown.selectDdOption(time);
    }

    private void chooseDatacenter(String center) {
        cloudCalculatorPage.datacenterDropdown.click();
        cloudCalculatorPage.datacenterDropdown.selectDdOption(center);
    }

    private void chooseLocalSsd(String ssd) {
        cloudCalculatorPage.localSsdDropdown.click();
        cloudCalculatorPage.localSsdDropdown.selectDdOption(ssd);
    }

    private void chooseGpuType(String gpuType) {
        cloudCalculatorPage.gpuTypeDropdown.click();
        cloudCalculatorPage.gpuTypeDropdown.selectDdOption(gpuType);
    }

    private void selectGpuCount(String count) {
        cloudCalculatorPage.gpuCountDropdown.click();
        cloudCalculatorPage.gpuCountDropdown.selectDdOption(count);
    }

    private void checkGPUcheckbox() {
        cloudCalculatorPage.addGPU.waitFor().clickability();
//        Actions actions = new Actions(Driver.getDriver());
//        actions.click(cloudCalculatorPage.addGPU.findElement()).build().perform();
        cloudCalculatorPage.addGPU.click();
    }

    private void chooseInstance(String instance) {
        cloudCalculatorPage.instanceDropdown.click();
        cloudCalculatorPage.instanceDropdown.selectDdOption(instance);
    }

    private void chooseVM(String vm) {
        cloudCalculatorPage.vmDropdown.click();
        cloudCalculatorPage.vmDropdown.selectDdOption(vm);
    }

    private void chooseOS(String os) {
        cloudCalculatorPage.osDropdown.click();
        cloudCalculatorPage.osDropdown.selectDdOption(os);
    }

    private void setInstanceCount(String count) {
        cloudCalculatorPage.instancesNum.waitFor().visibility();
        cloudCalculatorPage.instancesNum.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(cloudCalculatorPage.instancesNum.findElement(), count).build().perform();
    }

    @When("I press '(.+)' button")
    public void pressCalcButton(String but) {
        cloudCalculatorPage.calcButton.formatLocator(but).click();
    }

    @Then("estimations are displayed")
    public void areEstimationsDisplayed() {
        cloudCalculatorPage.estimationsBlock.waitFor().visibility();
        Assert.assertTrue("Estimations are not displayed", cloudCalculatorPage.estimationsBlock.findElement().isDisplayed());
    }

    @Then("total sum is '(.+)'")
    public void checkTotalSum(String sum) {
        Double expectedSum = Double.valueOf(sum.replace(",", ""));
        Double realSum = Double.valueOf(cloudCalculatorPage.totalSum.findElement().getText().split("USD ")[1].split(" per")[0].replace(",", ""));
        Assert.assertEquals("Real and expected sum do not match", expectedSum, realSum);
    }

    @Then("value matches between estimation and entered in form in field '(.+)'")
    public void compareValueInEstAndCalc(String fieldName) {
        cloudCalculatorPage.waitFor().pageIsLoaded();
        Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().switchTo().frame(0);
        String uiText = cloudCalculatorPage.estimationRow.formatLocator(fieldName).findElement().getText();

        if (fieldName.equalsIgnoreCase("VM class")) {
            Assert.assertEquals(uiText.split(": ")[1].toLowerCase(), vm.toLowerCase());
        } else if (fieldName.equalsIgnoreCase("Instance type")) {
            Assert.assertEquals(uiText.split(": ")[1].toLowerCase(), instance.split(" \\(")[0]);
        } else if (fieldName.equalsIgnoreCase("Region")) {
            Assert.assertEquals(uiText.split(": ")[1].toLowerCase(), datacenter.split(" \\(")[0].toLowerCase());
        } else if (fieldName.equalsIgnoreCase("local SSD")) {
            Assert.assertEquals(uiText.split("space ")[1].toLowerCase(), ssd.toLowerCase());
        } else if (fieldName.equalsIgnoreCase("Commitment term")) {
            Assert.assertEquals(uiText.split(": ")[1].toLowerCase(), usage.toLowerCase());
        }
    }

}

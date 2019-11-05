package pages.cloud;

import annotations.Locator;
import pages.AbstractPage;
import ui.Button;
import ui.CloudDropdown;
import ui.Element;
import ui.Textbox;

public class CloudCalculatorPage extends AbstractPage {

    @Locator(xpath = "//md-tabs-wrapper//div[@title='%s']")
    public Button calcTab;

    @Locator(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    public Textbox instancesNum;

    @Locator(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    public CloudDropdown osDropdown;

    @Locator(xpath = "//md-select[@ng-model='listingCtrl.computeServer.class']")
    public CloudDropdown vmDropdown;

    @Locator(xpath = "//md-select[@ng-model='listingCtrl.computeServer.instance']")
    public CloudDropdown instanceDropdown;

    @Locator(xpath = "//div[contains(text(), 'Add GPUs.')]")
    public Button addGPU;

    @Locator(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuCount']")
    public CloudDropdown gpuCountDropdown;

    @Locator(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuType']")
    public CloudDropdown gpuTypeDropdown;

    @Locator(xpath = "//md-select[@ng-model='listingCtrl.computeServer.ssd']")
    public CloudDropdown localSsdDropdown;

    @Locator(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    public CloudDropdown datacenterDropdown;

    @Locator(xpath = "//md-select[@ng-model='listingCtrl.computeServer.cud']")
    public CloudDropdown usageDropdown;

    @Locator(xpath = "//button[@aria-label='%s']")
    public Button calcButton;

    @Locator(id = "resultBlock")
    public Element estimationsBlock;

    @Locator(xpath = "//h2/b")
    public Element totalSum;

    @Locator(xpath = "//div[contains(text(), '%s')]")
    public Element estimationRow;
}

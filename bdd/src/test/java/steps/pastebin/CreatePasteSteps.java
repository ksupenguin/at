package steps.pastebin;

import cucumber.api.java.en.When;
import pages.pastebin.CreatePastePage;

public class CreatePasteSteps {

    private CreatePastePage createPastePage = new CreatePastePage();

    @When("I type \"(.+)\" text in '(.+)' textbox")
    public void typeTextOnCreatePaste(String text, String textboxName) {
        createPastePage.getTextboxByName(textboxName).type(text.replace("( +)", "\n"));
    }

    @When("I choose '(.+)' Paste Expiration")
    public void choosePasteExpiration(String expTime) {
        createPastePage.expirationDd.click();
        createPastePage.expirationDd.selectDdOption(expTime);
    }

    @When("I press Create new paste button")
    public void createNewPaste() {
        createPastePage.createPaste.click();
    }

    @When("I choose '(.+)' Syntax Highlighting")
    public void chooseSyntaxHighlight(String syntax) {
        createPastePage.syntaxDd.click();
        createPastePage.syntaxDd.selectDdOption(syntax);
    }
}

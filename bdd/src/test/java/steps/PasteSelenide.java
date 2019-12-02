package steps;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PasteSelenide {

    @Test
    public void userCanCreatePaste() {
        open("https://paste.ubuntu.com");
        $(By.id("id_content")).setValue("Hello from WebDriver");
        $(By.xpath("//select[@name = 'expiration']")).click();
        $(By.xpath("//option[text()='A day']")).click();
        $(By.id("id_poster")).setValue("helloweb");
        $(By.xpath("//input[@type = 'submit']")).click();
        $(By.cssSelector(".code .paste")).shouldBe(visible);
    }
}

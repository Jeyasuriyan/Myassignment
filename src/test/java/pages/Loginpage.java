package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement linkRegister;

    public Loginpage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clkRegister() {
        linkRegister.click();
    }
}

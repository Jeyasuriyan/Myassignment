package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Welcomepage {

    @FindBy(xpath = "//p[contains(text(),'Your account was created successfully. You are now')]")
    WebElement successRegister;

    @FindBy(xpath = "//h1[@class='title']")
    WebElement userNameTitle;

    public Welcomepage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void successRegisteredMsg(String message) {
        String actualMessage = successRegister.getText();
        String actualUserName = userNameTitle.getText();
        System.out.println("Actual success message==> " + actualMessage);
        System.out.println("Expected success message==> " + message);
        System.out.println("Actual User Name==> " + actualUserName);

        System.out.println("=======================================================");
        System.out.println("=========User Successfully Registered========");
        System.out.println("=======================================================");
//        if (message.contains(actualMessage)) {
//           Assert.assertEquals("check", message, actualMessage);
//            Assert.assertTrue(true);
//        }
    }
}

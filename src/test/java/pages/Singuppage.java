package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Singuppage {

    @FindBy(id = "customer.firstName")
    WebElement txtFirstName;

    @FindBy(id = "customer.lastName")
    WebElement txtLastName;

    @FindBy(id = "customer.address.street")
    WebElement txtAddress;

    @FindBy(id = "customer.address.city")
    WebElement txtCity;

    @FindBy(id = "customer.address.state")
    WebElement txtState;

    @FindBy(id = "customer.address.zipCode")
    WebElement txtZipcode;

    @FindBy(id = "customer.phoneNumber")
    WebElement txtPhoneNo;

    @FindBy(id = "customer.ssn")
    WebElement txtSsn;

    @FindBy(id = "customer.username")
    WebElement txtUserName;

    @FindBy(id = "customer.password")
    WebElement txtPassword;

    @FindBy(id = "repeatedPassword")
    WebElement txtConfirm;

    @FindBy(xpath = "//input[@value='Register']")
    WebElement btnRegister;

    public Singuppage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void signUp(String firstName, String lastName, String address, String city,
                       String state, String zipcode, String phoneNo, String ssn, String userName,
                       String password, String confirm) {
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        txtAddress.sendKeys(address);
        txtCity.sendKeys(city);
        txtState.sendKeys(state);
        txtZipcode.sendKeys(zipcode);
        txtPhoneNo.sendKeys(phoneNo);
        txtSsn.sendKeys(ssn);
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
        txtConfirm.sendKeys(confirm);
    }

    public void submitRegister() {
        btnRegister.submit();
    }

}

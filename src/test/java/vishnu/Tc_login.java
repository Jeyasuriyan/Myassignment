package vishnu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.stream.StreamSupport;

public class Tc_login {

    WebDriver driver;

    @Given("I hit the login url")
    public void iHitTheLoginUrl() {
        //open browser
        // hit the url
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://liverlifeweb.myliverlife.online/login");
    }

    @When("I enter the details {string}, {string}, {string}")
    public void iEnterTheDetails(String userName, String password, String check) throws InterruptedException {
        // enter the details
        driver.findElement(By.id("email")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("click on login")
    public void clickOnLogin() throws InterruptedException {
        // login click
        driver.findElement(By.id("login")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
    }

    @Then("if the details are valid it will redirect home page else it will stay in login page with error")
    public void ifTheDetailsAreValidItWillRedirectHomePageElseItWillStayInLoginPageWithError() {
        // validate the login

        if (driver.getCurrentUrl().equals("https://liverlifeweb.myliverlife.online/resources")) {
            System.out.print("Logged in Success");
        } else {
            System.out.println("Empty field or Credentials are wrong");
        }
        driver.close();
    }
}

// Click on resources
// Click on checkbox
// Check the link is filled in myinput element

package vishnu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Tc_preloadedlogo {

    WebDriver driver;

    @Given("I login using {string} and {string}")
    public void iLoginUsingAnd(String userName, String password) throws InterruptedException {
        //open browser
        // hit the url
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://liverlifeweb.myliverlife.online/login");

        // enter the details
        driver.findElement(By.id("email")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        Thread.sleep(3000);
    }

    @When("I click on resources")
    public void iClickOnResources() {
        driver.findElement(By.xpath("//a[contains(text(),'Get Resources')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement e = driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/h2[1]"));
        wait.until(ExpectedConditions.visibilityOf(e));
        System.out.println("Get Resources button is working")
        driver.navigate().back();
        driver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
    }

    @And("Click on View or Customize button")
    public void clickOnViewCustomizeButton() {
        driver.findElement(By.xpath("//body/div[3]/div[4]/div[1]/div[1]/div[1]/div[2]/a[1]")).click();
    }

    @When("Click on the check box to generate the url")
    public void clickOnTheCheckBoxToGenerateTheUrl() {
        driver.findElement(By.xpath(
                "//label[contains(text(),\"Go to my profile settings to grab my organization'\")]")).click();

    }

    @Then("Validate the Url is generated or not")
    public void validateTheUrlIsGeneratedOrNot() throws InterruptedException {
        String url = driver.findElement(By.xpath("//input[@id='myInput']")).getText();
        System.out.println("url = " + url);
//
//        while (!url.contains("https://")) {
//            System.out.println("not");
//        }
        for (int i = 0; i <= 5; i++) {
            Thread.sleep(5000);
            String urlGetter = urlGetter();
            if (urlGetter.contains("https://")) {
                System.out.println("Url got generated");
                driver.close();
                break;
            } else {
                System.out.println("Still the url not generated");
            }
        }

//        while (true) {
//            Thread.sleep(5000);
//            String urlGetter = urlGetter();
//            if (urlGetter.contains("https://")) {
//                System.out.println("Url got generated");
//                break;
//            } else {
//                System.out.println("Still the url not generated");
//            }
//        }
    }

    public String urlGetter() {
        Actions action = new Actions(driver);
        WebElement e = driver.findElement(By.xpath("//input[@id='myInput']"));
        action.moveToElement(e).click().build().perform();
        String urlGetter = driver.findElement(By.xpath("//input[@id='myInput']")).getAttribute("value");
        System.out.println("url = " + urlGetter);
        return urlGetter;
    }
}

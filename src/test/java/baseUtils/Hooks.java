package baseUtils;

import baseUtils.Base;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class Hooks extends Base {

    private final Base base;

    public Hooks(Base base) {
        this.base = base;
    }

    @Before
    public void driverSetup(Scenario scenario) {
//        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
//        base.driver = new ChromeDriver();
//        base.driver.manage().window().maximize();

        WebDriverManager.chromedriver().browserVersion("90.0.4430.212").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        base.driver = new ChromeDriver(options);

        System.out.println("Browser started");
        base.driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");

//        base.logger = Logger.getLogger("Assignment One");
//        PropertyConfigurator.configure("src/test/resources/log4j.properties");
    }

    @AfterStep
    public void checking(Scenario scenario) throws IOException {

        String ss = screenshot(scenario.getName(), base.driver);

        scenario.attach(FileUtils.readFileToByteArray(new File(ss)), ".PNG", ss);
    }

    @After
    public void tearDown(Scenario scenario) {
        base.driver.close();
    }

    public String screenshot(String name, WebDriver driver) {

        String tar = "target/screenshots/" + name + ".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(tar));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tar;
    }
}

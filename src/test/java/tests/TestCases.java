package tests;

//import engine.Bot;

import engine.Bot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestCases {
    protected WebDriver driver;
    protected Bot bot;

    @BeforeMethod
    public void setUp() {

        // driver initialization for Chrome
        ChromeOptions options;
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setBrowserVersion("134");
//        options.setCapability("webSocketUrl", true);
//        options.setImplicitWaitTimeout(Duration.ofSeconds(5));
        driver = new ChromeDriver(options);

        // bot initialization
        bot = new Bot(driver);


        // driver initialization for Firefox
//        FirefoxOptions Foptions;
//        Foptions = new FirefoxOptions();
//        // Foptions.addArguments("--start-maximized");
//        driver = new FirefoxDriver(Foptions);
//        driver.manage().window().maximize();
//        bot = new Bot(driver);

    }

    @AfterMethod
    public void tearDown() {
        // driver termination
        if (driver != null) {
            driver.quit();
        }
    }
}

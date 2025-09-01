package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        // Set default configurations
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        // Open the target webpage
        driver.get("https://www.analyticsvidhya.com/datahack/contest/practice-problem-loan-prediction-iii/");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

package frontend.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageLoanPrediction {

    WebDriver driver;
    WebDriverWait wait;

    // Locator for the home page banner
    @FindBy(xpath = "//div/img[@class='img-fluid rounded-2']")
    WebElement homePageBannerImage;
    
    @FindBy(xpath="//div[@class='modal-body p-md-4 row']")
    WebElement popupGetProgramDetails;
    
    @FindBy(id="leadEmail")
    WebElement emailPlaceHolder;

    @FindBy(id="userPhoneNumber")
    WebElement phoneNoPlaceHolder;
    
    @FindBy(xpath="//div/button[contains(text(),'Get Program Details')]")
    WebElement getProgramDetailsBtn;
    
    @FindBy(xpath="//div[contains(text(),'Generating Brochure.')]")
    WebElement sucessText;
    
    // Constructor
    public HomePageLoanPrediction(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        PageFactory.initElements(driver, this);
    }

    // Method to check if the banner is visible
    public boolean isBannerVisible() {
        WebElement banner = wait.until(ExpectedConditions.visibilityOf(homePageBannerImage));
        return banner.isDisplayed();
    }

    // Method to get page title
    public String getPageTitle() {
        return driver.getTitle();
    }
    public boolean popupGetProgramBanner() {
        WebElement popup = wait.until(ExpectedConditions.visibilityOf(popupGetProgramDetails));
        return popup.isDisplayed();
    
    }
    public void submitEmailId() {
    	emailPlaceHolder.sendKeys("pehwhbxud@gmail.com");
    }
    public void submitPhoneNumber() {
    	phoneNoPlaceHolder.sendKeys("8036578921");
    }
    public void clickProgramDetailsBtn() {
    	getProgramDetailsBtn.click();
    }
    public String getSucessText() {
    	return sucessText.getText();
    }
    
    
}

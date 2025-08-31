package frontend.tests;


import base.BaseTest;
import frontend.pages.HomePageLoanPrediction;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PageLoadTest extends BaseTest {

    @Test
    public void verifyPageLoad() {
        HomePageLoanPrediction home = new HomePageLoanPrediction(driver);
        System.out.println(home.getPageTitle());
        Assert.assertTrue(home.isBannerVisible(), "Banner section is not visible.");
        
        Assert.assertTrue(home.getPageTitle().contains("Loan Prediction"),
                "Page title does not contain expected text.");
    }
}


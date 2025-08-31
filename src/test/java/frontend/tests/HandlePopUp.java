package frontend.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import frontend.pages.HomePageLoanPrediction;

public class HandlePopUp extends BaseTest {
	@Test
	public void getProgramVisible() {
		HomePageLoanPrediction home = new HomePageLoanPrediction(driver);
		Assert.assertTrue(home.popupGetProgramBanner(), "Popup for Get Program Details is not visible.");

	}
	@Test
	public void fillInputBox() {
		HomePageLoanPrediction home = new HomePageLoanPrediction(driver);
		home.popupGetProgramBanner();
		home.submitEmailId();
		home.submitPhoneNumber();
		home.clickProgramDetailsBtn();
	}
}

package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

public class HomePageObject extends BasePage{
	
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(className="ico-register")
	WebElement registerLink;
	
	@FindBy(className="ico-login")
	WebElement loginLink;
	
	@FindBy(className="ico-account")
	WebElement myAccountLink;
	
	public void clickToRegisterButton() {
		waitElementToBeClickable(driver, registerLink);
		clickToElement(registerLink);
	}
	public String getHomePageURL() {
		return getPageUrl(driver);
	}
	public void clickToLoginLink() {
		waitElementToBeClickable(driver, loginLink);
		clickToElement(loginLink);
	}
	public boolean isMyAccountLinkDisplayed() {
		return isElementDisplayed(myAccountLink);
	}
	public void clickToMyAccountLink() {
		waitElementToBeClickable(driver, myAccountLink);
		clickToElement(myAccountLink);
	}

}

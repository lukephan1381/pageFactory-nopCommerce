package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

public class LoginPageObject extends BasePage {
	
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id="Email")
	WebElement emailTextbox;
	
	@FindBy(id="Password")
	WebElement passwordTextbox;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement loginButton;
	
	public void inputToEmailTextbox(String emailAddress) {
		waitElementToBeVisible(driver, emailTextbox);
		sendKeyToElement(emailTextbox, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitElementToBeVisible(driver, passwordTextbox);
		sendKeyToElement(passwordTextbox, password);
	}

	public void clickToLoginButton() {
		waitElementToBeClickable(driver, loginButton);
		clickToElement(loginButton);
	}

}

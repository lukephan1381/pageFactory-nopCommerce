package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

public class RegisterPageObject extends BasePage {
	
	WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id="gender-male")
	WebElement genderMaleRadio;
	
	@FindBy(id="gender-female")
	WebElement genderFemaleRadio;
	
	@FindBy(id="FirstName")
	WebElement firstNameTextbox;
	
	@FindBy(id="LastName")
	WebElement lastNameTextbox;
	
	@FindBy(name="DateOfBirthDay")
	WebElement dayDropdown;
	
	@FindBy(name="DateOfBirthMonth")
	WebElement monthDropdown;
	
	@FindBy(name="DateOfBirthYear")
	WebElement yearDropdown;
	
	@FindBy(id="Email")
	WebElement emailTextbox;
	
	@FindBy(id="Company")
	WebElement companyTextbox;
	
	@FindBy(id="Password")
	WebElement passwordTextbox;
	
	@FindBy(id="ConfirmPassword")
	WebElement passwordConfirmTextbox;
	
	@FindBy(id="register-button")
	WebElement registerButton;
	
	@FindBy(className ="ico-logout")
	WebElement logoutLink;
	
	@FindBy(className="result")
	WebElement registerSuccessMessage;
	
	public void clickToGenderMaleRadio() {
		waitElementToBeClickable(driver, genderMaleRadio);
		checkOnCheckboxOrRadio(genderMaleRadio);
	}
	
	public void clickToGenderFemaleRadio() {
		waitElementToBeClickable(driver, genderFemaleRadio);
		checkOnCheckboxOrRadio(genderMaleRadio);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitElementToBeVisible(driver, firstNameTextbox);
		sendKeyToElement(firstNameTextbox, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitElementToBeVisible(driver, lastNameTextbox);
		sendKeyToElement(lastNameTextbox, lastName);
	}

	public void selectDayDropdown(String textValue) {
		waitElementToBeVisible(driver, dayDropdown);
		selectItemInDropdown(dayDropdown, textValue);
	}

	public void selectMonthDropdown(String textValue) {
		waitElementToBeVisible(driver, dayDropdown);
		selectItemInDropdown(monthDropdown, textValue);
	}

	public void selectYearDropdown(String textValue) {
		waitElementToBeVisible(driver, yearDropdown);
		selectItemInDropdown(yearDropdown, textValue);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitElementToBeVisible(driver, emailTextbox);
		sendKeyToElement(emailTextbox, emailAddress);
	}

	public void inputToCompanyTextbox(String companyName) {
		waitElementToBeVisible(driver, companyTextbox);
		sendKeyToElement(companyTextbox, companyName);
	}

	public void inputToPasswordTextbox(String password) {
		waitElementToBeVisible(driver, passwordTextbox);
		sendKeyToElement(passwordTextbox, password);
	}

	public void inputToConfirmPasswordTextbox(String passwordConfirm) {
		waitElementToBeVisible(driver, passwordConfirmTextbox);
		sendKeyToElement(passwordTextbox, passwordConfirm);
	}

	public void clickToRegisterButton() {
		waitElementToBeClickable(driver, registerButton);
		clickToElement(registerButton);
	}

	public String getRegisterResultMessage() {
		waitElementToBeVisible(driver, registerSuccessMessage);
		return registerSuccessMessage.getText();
	}

	public void clickToLogoutLink() {
		waitElementToBeVisible(driver, logoutLink);
		clickToElement(logoutLink);
	}

}

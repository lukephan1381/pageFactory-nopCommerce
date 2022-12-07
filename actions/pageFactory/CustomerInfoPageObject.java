package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

public class CustomerInfoPageObject extends BasePage{

	WebDriver driver;
	
	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id="save-info-button")
	WebElement saveButton;
	
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
	
	public void clickToSaveButton() {
		waitElementToBeClickable(driver, saveButton);
		clickToElement(driver,saveButton);
	}
	
	public boolean isGenderMaleRadioSelected() {
		waitElementToBeVisible(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
	}
	
	public boolean isGenderFemaleRadioSelected() {
		waitElementToBeVisible(driver, CustomerInfoPageUI.GENDER_FEMALE_RADIO);
		return isElementSelected(driver, CustomerInfoPageUI.GENDER_FEMALE_RADIO);
	}
	
	public String getFirstNameTextboxAttribute(String attributeName) {
		waitElementToBeVisible(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX, attributeName);
	}
	
	public String getLastNameTextboxAttribute(String attributeName) {
		waitElementToBeVisible(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX, attributeName);
	}
	
	public String getDayDropdownSelectedItem() {
		waitElementToBeVisible(driver, CustomerInfoPageUI.DAY_DROPDOWN);
		return getSelectedItemInDropdown(driver, CustomerInfoPageUI.DAY_DROPDOWN);
	}
	
	public String getMonthDropdownSelectedItem() {
		waitElementToBeVisible(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
		return getSelectedItemInDropdown(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
	}
	
	public String getYearDropdownSelectedItem() {
		waitElementToBeVisible(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
		return getSelectedItemInDropdown(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
	}
	
	public String getEmailTextboxAttribute(String attributeName) {
		waitElementToBeVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, attributeName);
	}
	
	public String getCompanyTextboxAttribute(String attributeName) {
		waitElementToBeVisible(driver, CustomerInfoPageUI.COMPANY_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.COMPANY_TEXTBOX, attributeName);
	}

}

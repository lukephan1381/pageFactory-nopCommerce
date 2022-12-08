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
		clickToElement(saveButton);
	}
	
	public boolean isGenderMaleRadioSelected() {
		waitElementToBeVisible(driver, genderMaleRadio);
		return isElementSelected(genderMaleRadio);
	}
	
	public boolean isGenderFemaleRadioSelected() {
		waitElementToBeVisible(driver, genderFemaleRadio);
		return isElementSelected(genderFemaleRadio);
	}
	
	public String getFirstNameTextboxValue() {
		waitElementToBeVisible(driver, firstNameTextbox);
		return getElementAttributeValue(firstNameTextbox);
	}
	
	public String getLastNameTextboxValue() {
		waitElementToBeVisible(driver, lastNameTextbox);
		return getElementAttributeValue(lastNameTextbox);
	}
	
	public String getDayDropdownSelectedItem() {
		waitElementToBeVisible(driver, dayDropdown);
		return getSelectedItemInDropdown(dayDropdown);
	}
	
	public String getMonthDropdownSelectedItem() {
		waitElementToBeVisible(driver, monthDropdown);
		return getSelectedItemInDropdown(monthDropdown);
	}
	
	public String getYearDropdownSelectedItem() {
		waitElementToBeVisible(driver, yearDropdown);
		return getSelectedItemInDropdown(yearDropdown);
	}
	
	public String getEmailTextboxValue() {
		waitElementToBeVisible(driver, emailTextbox);
		return getElementAttributeValue(emailTextbox);
	}
	
	public String getCompanyTextboxValue() {
		waitElementToBeVisible(driver, companyTextbox);
		return getElementAttributeValue(emailTextbox);
	}

}

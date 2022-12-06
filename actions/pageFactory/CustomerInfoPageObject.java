package pageFactory;

import org.openqa.selenium.WebDriver;
import pageUIs.CustomerInfoPageUI;
import commons.BasePage;

public class CustomerInfoPageObject extends BasePage{

	WebDriver driver;
	
	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToSaveButton() {
		waitElementToBeClickable(driver, CustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver,CustomerInfoPageUI.SAVE_BUTTON);
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

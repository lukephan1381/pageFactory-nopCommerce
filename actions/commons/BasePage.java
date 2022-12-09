package commons;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	/* Web Browser */
	
	public void openURL(WebDriver driver, String pageURL) {
		driver.get(pageURL);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void navigatePageBack(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void navigatePageForward(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void pageRefresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public Alert waitAlertPresence(WebDriver driver) {
		//return new WebDriverWait(driver, 15).until(ExpectedConditions.alertIsPresent());
		return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());
	}
	
	public void alertAccept(WebDriver driver) {
		waitAlertPresence(driver).accept();
	}
	
	public void alertCancel(WebDriver driver) {
		waitAlertPresence(driver).dismiss();
	}
	
	public void alertGetText(WebDriver driver) {
		waitAlertPresence(driver).getText();
	}
	
	public void alertSendKeys(WebDriver driver, String alertText) {
		waitAlertPresence(driver).sendKeys(alertText);
	}
	
	public void switchToWindowByID(WebDriver driver, String parentTab) {
		Set<String> allTabs = driver.getWindowHandles();
		for (String currentTab : allTabs) {
			if (!currentTab.equals(parentTab))
				;
			driver.switchTo().window(currentTab);
		}
	}
	
	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allTabs = driver.getWindowHandles();
		for (String currentTab : allTabs) {
			driver.switchTo().window(currentTab);
			String currentTabTitle = driver.getTitle();
			if (currentTabTitle.equals(title)) {
				break;
			}
		}
	}
	
	public void closeAllWindowsExceptParent(WebDriver driver, String parentTab) {

		Set<String> allTabs = driver.getWindowHandles();
		for (String currentTab : allTabs) {
			if (!currentTab.equals(parentTab)) {
				driver.switchTo().window(currentTab);
				driver.close();
			}
		}
		driver.switchTo().window(parentTab);
	}
	
	/* Web Element*/
	
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	
	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	
	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}
	
	public void clickToElement(WebElement element) {
		element.click();
	}
	
	public void sendKeyToElement(WebElement element, String valueToSendKey) {
		element.sendKeys(valueToSendKey);
	}
	
	public void selectItemInDropdown(WebElement element, String textValue) {
		new Select(element).selectByVisibleText(textValue);
	}
	
	public String getSelectedItemInDropdown(WebElement element) {
		return new Select(element).getFirstSelectedOption().getText();
	}
	
	public Boolean isDropdownMultiple(WebDriver driver, String locator) {
		return new Select(getElement(driver, locator)).isMultiple();
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String expectedTextItem) {
		getElement(driver, parentLocator).click();
		sleepInSecond(3);

		List<WebElement> allDropdownItems = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childLocator)));
		
		for (WebElement item : allDropdownItems) {
			String actualTextItem = item.getText();
			System.out.println(item);
			if (actualTextItem.equals(expectedTextItem)) {
				//System.out.println(actualTextItem);
				//jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				item.click();
				break;
			}
		}
	}
	
	public String getElementAttributeValue(WebElement element) {
		return element.getAttribute("value");
	}
	
	public void getElementCSSValue(WebDriver driver, String locator, String propertyName) {
		getElement(driver, locator).getCssValue(propertyName);
	}
	
	public String getHexColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	public int getElementsSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}
	
	public void checkOnCheckboxOrRadio(WebElement element) {
		if (!element.isSelected()) {
			element.click();;
		}
	}
	
	public void uncheckTheCheckbox(WebElement element) {
		if (element.isSelected()){
			clickToElement(element);
		}
	}
	
	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}
	
	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}
	
	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getElement(driver, locator));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void moveToElement(WebDriver driver, String locator) {
		new Actions(driver).moveToElement(getElement(driver, locator)).perform();
	}
	
	public void doubleClickToElement(WebDriver driver, String locator) {
		new Actions(driver).doubleClick(getElement(driver, locator)).perform();
	}
	
	public void rightClickElement(WebDriver driver, String locator) {
		new Actions(driver).contextClick(getElement(driver, locator)).perform();
	}
	
	public void dragAndDrop(WebDriver driver, String sourceLocator, String targetLocator) {
		new Actions(driver).dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();;
	}
	
	public void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
		new Actions(driver).sendKeys(getElement(driver, locator), key).perform();
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*Javascripts executor*/
	
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		return ((JavascriptExecutor) driver).executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		//WebDriverWait explicitWait = new WebDriverWait(driver, 15);
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	/* Waits */
	
	public void waitElementToBeVisible(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitElementToBeClickable(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitElementToBeInvisible(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitListElementsToBeVisible(WebDriver driver, WebElement elements) {
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	public void waitListElementsToBeInvisibile(WebDriver driver, WebElement elements) {
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	public void waitElementPresence(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.presenceOfElementLocated(getByXpath(locator)));
	}
	
	public void waitListElementsPresence(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(locator)));
	}

}

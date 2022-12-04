package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	public WebDriver getBrowserDriver(String browserName) {
		BrowserName browser = BrowserName.valueOf(browserName.toUpperCase());
		switch(browser)	{
		case FIREFOX:
			driver = WebDriverManager.firefoxdriver().create();
			//System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			//driver = new FirefoxDriver();
			break;
		case CHROME:
			driver = WebDriverManager.chromedriver().create();
			//System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
			//driver = new ChromeDriver();
			break;
		case EDGE:
			driver = WebDriverManager.edgedriver().create();
			//System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
			//driver = new EdgeDriver();
			break;
		case OPERA:
			driver = WebDriverManager.operadriver().create();
			//System.setProperty("webdriver.opera.driver", projectPath + "/browserDrivers/operadriver");
			//driver = new OperaDriver();
			break;
		default:
			throw new RuntimeException("Cannot find browser name.");
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		return driver;
	}
	
	public int generateRandomNumber() {
		Random email = new Random();
		return email.nextInt(9999);
	}
}

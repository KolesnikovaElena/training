

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.logging.Level;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	public WebDriver driver;
	public WebDriverWait wait;

	public ExpectedCondition<String> thereIsWindowOtherThan (Set<String> oldWindows) {
		return new ExpectedCondition<String>() {
			public String apply(WebDriver driver) {
				Set<String> handles = driver.getWindowHandles();
				handles.removeAll(oldWindows);
				return handles.size() > 0 ? handles.iterator().next() : null;
			}
		};
	}

	@Before
	public void start() {
		if (tlDriver.get() != null) {
			driver = tlDriver.get();
			wait = new WebDriverWait(driver, 10);
			return;
		}

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

		driver = new ChromeDriver(cap);
		tlDriver.set(driver);
		wait = new WebDriverWait(driver, 10);

		Runtime.getRuntime().addShutdownHook(
				new Thread(() -> { driver.quit(); driver = null; }));
	}

	@After
	public void stop() {
		//driver.quit();
		//driver = null;
	}

	public void unhide(WebDriver driver, WebElement element) {
		String script = "arguments[0].style.opacity=1;"
				+ "arguments[0].style['transform']='translate(0px, 0px) scale(1)';"
				+ "arguments[0].style['MozTransform']='translate(0px, 0px) scale(1)';"
				+ "arguments[0].style['WebkitTransform']='translate(0px, 0px) scale(1)';"
				+ "arguments[0].style['msTransform']='translate(0px, 0px) scale(1)';"
				+ "arguments[0].style['OTransform']='translate(0px, 0px) scale(1)';"
				+ "return true;";
		((JavascriptExecutor) driver).executeScript(script, element);
	}

	public void attachFile(WebDriver driver, By locator, String file) {
		WebElement input = driver.findElement(locator);
		unhide(driver, input);
		input.sendKeys(file);
	}

	protected boolean isElementPresent(WebDriver driver, By locator) {
		try {
			driver.findElement(locator);
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
	public  boolean areElementsPresent(WebDriver driver, By locator) {
		return driver.findElements(locator).size() > 0;
	}
}

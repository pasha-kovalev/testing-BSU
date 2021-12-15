package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
	private static final Logger LOG = LogManager.getLogger(AbstractPage.class);
	protected WebDriver driver;
	protected final int WAIT_TIMEOUT_SECONDS = 10;

	protected AbstractPage(WebDriver driver)
	{
		this.driver = driver;
	}

	protected WebElement findElementByLocatorAndClickStaleElementReferenceException(By locator) {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			LOG.warn(e);
		}
		WebElement element = (new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS))
					.until(ExpectedConditions.elementToBeClickable(findElementByLocator(locator)));
			element.click();
			return element;
	}

	protected WebElement findElementByLocator(By locator) {
		return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions
						.presenceOfElementLocated(locator));
	}

	protected String getTextFrom(By locator) {
		return findElementByLocator(locator).getText();
	}
}

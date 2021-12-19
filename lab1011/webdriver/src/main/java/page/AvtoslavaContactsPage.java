package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AvtoslavaContactsPage extends AbstractPage {
    private static final Logger LOG = LogManager.getLogger(AvtoslavaContactsPage.class);

    private final JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
    private final By messageInputLocator = By.xpath("//textarea[@name='page_20-field_3']");
    private final By nameInvalidInputLocator = By.cssSelector("input#id_page_20-field_0");

    public AvtoslavaContactsPage(WebDriver driver) {
        super(driver);
    }

    public AvtoslavaContactsPage enterMessage(String msg) {
        findElementByLocatorAndClick(messageInputLocator)
                .sendKeys(msg);
        LOG.info("message entered");
        return this;
    }

    public boolean isValidInput() {
        return (Boolean) javascriptExecutor.executeScript("return arguments[0].checkValidity();",
                findElementByLocator(nameInvalidInputLocator));
    }

}

package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AvtoslavaOrderResultPage extends AbstractPage {
    private static final Logger LOG = LogManager.getLogger(AvtoslavaOrderResultPage.class);

    private final By reserveMessageLocator = By.xpath("//div[@class='timetable-reservation-form-body']/" +
            "/h2");

    private final By smsTextLocator = By.xpath("//*[contains(text(),'SMS код проверки ')]");

    protected AvtoslavaOrderResultPage(WebDriver driver) {
        super(driver);
    }

    public String getTextFromReserveResponse() {
        LOG.info("getting text from reserve response...");
        return getTextFrom(reserveMessageLocator);
    }

    public List<WebElement> findSmsText() {
        return driver.findElements(smsTextLocator);
    }
}

package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AvtoslavaOrderResultPage extends AbstractPage{
    private static final Logger LOG = LogManager.getLogger(AvtoslavaOrderResultPage.class);

    private final By reserveFineLocator = By.xpath("//div[@class='timetable-reservation-form-body']/" +
            "/h2");

    protected AvtoslavaOrderResultPage(WebDriver driver) {
        super(driver);
    }

    public String getTextFromReserveResponse() {
        LOG.info("getting text from reserve response...");
        return getTextFrom(reserveFineLocator);
    }

}

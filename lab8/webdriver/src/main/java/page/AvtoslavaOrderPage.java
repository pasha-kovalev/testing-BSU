package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AvtoslavaOrderPage extends AbstractPage{
    private static final Logger LOG = LogManager.getLogger(AvtoslavaOrderPage.class);

    private final By inputReserveLocator = By.xpath("//input[@type='submit'][@class='btn btn-primary']" +
            "[@value='Забронировать']");

    private final By checkBoxLocator = By.xpath("//input[@type='checkbox']" +
            "[@class='ng-pristine ng-invalid ng-invalid-required']");

    private final By nameInputLocator = By.xpath("//input[@name='firstname']");

    private final By phoneInputLocator = By.xpath("//input[@name='phone']" +
            "[@class='form-control ng-pristine ng-invalid ng-invalid-required']");
    private final By stationSelectLocator = By.xpath("//select[@name='station']" +
            "[@class='form-control ng-pristine ng-invalid ng-invalid-required']" +
            "/option[@value='4' or @value='28']");

    private final By seatsSelectLocator =
            By.xpath("//select[@name='seats[price.price_id]']" +
                    "[@class='form-control timetable-form-price-selector ng-pristine ng-valid']" +
                    "/option[@value='1']");

    protected AvtoslavaOrderPage(WebDriver driver) {
        super(driver);
    }

    public AvtoslavaOrderResultPage clickOnReserve() {
        findElementByLocatorAndClickStaleElementReferenceException(inputReserveLocator);
        LOG.info("auto reserved");
        return new AvtoslavaOrderResultPage(driver);
    }

    public AvtoslavaOrderPage clickCheckBox() {
        findElementByLocatorAndClickStaleElementReferenceException(checkBoxLocator);
        LOG.info("order checkbox clicked");
        return this;
    }

    public AvtoslavaOrderPage enterName(String name) {
        findElementByLocatorAndClickStaleElementReferenceException(nameInputLocator)
                .sendKeys(name);
        LOG.info("name entered: ");
        return this;
    }

    public AvtoslavaOrderPage enterPhone(String phone) {
        findElementByLocatorAndClickStaleElementReferenceException(phoneInputLocator)
                .sendKeys(phone);
        LOG.info("phone entered:");
        return this;
    }

    public AvtoslavaOrderPage selectStation() {
        findElementByLocatorAndClickStaleElementReferenceException(stationSelectLocator);
        LOG.info("station selected");
        return this;
    }

    public AvtoslavaOrderPage selectNumOfSeats() {
        findElementByLocatorAndClickStaleElementReferenceException(seatsSelectLocator);
        LOG.info("seats selected");
        return this;
    }
}

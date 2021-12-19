package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AvtoslavaBookingPage extends AbstractPage {
    private static final Logger LOG = LogManager.getLogger(AvtoslavaBookingPage.class);

    private final By phoneInputLocator = By.xpath("//input[@name='phone']" +
            "[@class='form-control discard-phone ng-pristine ng-invalid ng-invalid-required ng-valid-mask']");

    private final By smsInputLocator = By.xpath("//input[@placeholder='SMS код']" +
            "[@class='form-control discard-smscode ng-pristine ng-valid']");

    private final By buttonComplete = By.xpath("//button[@class='btn btn-primary']" +
            "[text()='Подтвердить']");

    private final By smsErrorTextLocator = By.xpath("//div[@style='color: #b30']" +
            "[contains(text(), 'Введите правильный код SMS')]");

    public AvtoslavaBookingPage(WebDriver driver) {
        super(driver);
    }

    public AvtoslavaBookingPage enterPhone(String phone) {
        findElementByLocatorAndClick(phoneInputLocator)
                .sendKeys(phone);
        LOG.info("phone entered");
        return this;
    }

    public AvtoslavaBookingPage enterSms(String sms) {
        findElementByLocatorAndClick(smsInputLocator)
                .sendKeys(sms);
        LOG.info("sms entered");
        return this;
    }

    public AvtoslavaBookingPage clickOnComplete() {
        findElementByLocatorAndClick(buttonComplete);
        LOG.info("button clicked");
        return this;
    }

    public List<WebElement> findSmsErrorText() {
        return driver.findElements(smsErrorTextLocator);
    }
}

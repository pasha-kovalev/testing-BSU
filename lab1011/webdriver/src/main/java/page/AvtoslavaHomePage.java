package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AvtoslavaHomePage extends AbstractPage {
    private static final Logger LOG = LogManager.getLogger(AvtoslavaHomePage.class);
    private static final String HOMEPAGE_URL = "https://avto-slava.by/";

    private final By buttonSubmitDriveLocator = By.xpath("//button[@class='btn btn-primary'][text()=' Оформить ']");

    private final By routeSelectLocator = By.xpath("//div[@class='route-buttons']" +
            "/select[@class='form-control ng-pristine ng-valid']/option[@value='1']");

    private final By buttonTomorrow = By.xpath("//button[@class='btn btn-sm btn-info'][text()='Послезавтра']");

    private final By buttonCalendar = By.xpath("//button[@class='btn btn-default']" +
            "/i[@class='glyphicon glyphicon-calendar']");

    private final By buttonMyBooking = By.xpath("//button[@class='btn btn-sm btn-route discard-trip']" +
            "[text()=' Мои брони']");

    private final By contactsLi = By.xpath("//li/a[@title='Контакты']");

    private final By homeLink = By.xpath("//*/a[@title='АвтоСлава®']");

    public AvtoslavaHomePage(WebDriver driver) {
        super(driver);
    }

    public AvtoslavaHomePage openHomePage() {
        driver.get(HOMEPAGE_URL);
        LOG.info("home page opened");
        return this;
    }

    public AvtoslavaBookingPage clickOnMyBooking() {
        findElementByLocatorAndClick(buttonMyBooking);
        LOG.info("booking opened");
        return new AvtoslavaBookingPage(driver);
    }

    public AvtoslavaContactsPage clickOnContacts() {
        findElementByLocatorAndClick(contactsLi);
        LOG.info("contacts opened");
        return new AvtoslavaContactsPage(driver);
    }

    public AvtoslavaOrderPage clickOnSubmitDrive() {
        findElementByLocatorAndClick(buttonSubmitDriveLocator);
        LOG.info("drive submitted");
        return new AvtoslavaOrderPage(driver);
    }

    public AvtoslavaHomePage openNewWindowHomePage() {
        new Actions(driver).keyDown(Keys.CONTROL)
                .click(findElementByLocator(homeLink))
                .keyUp(Keys.CONTROL)
                .build()
                .perform();
        return new AvtoslavaHomePage(driver);
    }

    public AvtoslavaHomePage clickOnCalendar() {
        findElementByLocatorAndClick(buttonCalendar);
        LOG.info("calendar clicked");
        return this;
    }

    public AvtoslavaHomePage clickOnCalendarDay(int day) {
        By buttonCalendarDay = By.xpath(String.format("//span[@class='ng-binding'][text()='%d']", day));
        findElementByLocatorAndClick(buttonCalendarDay);
        LOG.info("calendar clicked");
        return this;
    }

    public AvtoslavaHomePage clickOnTomorrow() {
        findElementByLocatorAndClick(buttonTomorrow);
        LOG.info("tomorrow clicked");
        return this;
    }

    public AvtoslavaHomePage selectRoute() {
        findElementByLocatorAndClick(routeSelectLocator);
        LOG.info("route selected");
        return this;
    }

    public List<WebElement> findElementsInPanelBy(String text) {
        return driver.findElements(By.xpath("//div[@class='panel panel-default']//*[contains(text(),'" + text + "')]"));
    }
}

package page;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AvtoslavaHomePage {
    public static final int TIMEOUT_IN_SECONDS = 20;
    private static final String HOMEPAGE_URL = "https://avto-slava.by/";

    private final WebDriver driver;

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

    private final By buttonSubmitDriveLocator = By.xpath("//button[@class='btn btn-primary'][text()=' Оформить ']");

    private final By inputReserveLocator = By.xpath("//input[@type='submit'][@class='btn btn-primary']" +
            "[@value='Забронировать']");

    private final By buttonTomorrow = By.xpath("//button[@class='btn btn-sm btn-info'][text()='Послезавтра']");

    private final By reserveFineLocator = By.xpath("//div[@class='timetable-reservation-form-body']/" +
            "/h2");

    public AvtoslavaHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public AvtoslavaHomePage openHomePage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public AvtoslavaHomePage clickCheckBox() {
        findElementByLocatorAndClickStaleElementReferenceException(checkBoxLocator);
        return this;
    }

    public AvtoslavaHomePage enterName(String name) {
        findElementByLocatorAndClickStaleElementReferenceException(nameInputLocator)
                .sendKeys(name);
        return this;
    }

    public AvtoslavaHomePage enterPhone(String phone) {
        findElementByLocatorAndClickStaleElementReferenceException(phoneInputLocator)
                .sendKeys(phone);
        return this;
    }

    public AvtoslavaHomePage selectStation() {
        findElementByLocatorAndClickStaleElementReferenceException(stationSelectLocator);
        return this;
    }

    public AvtoslavaHomePage selectNumOfSeats() {
        findElementByLocatorAndClickStaleElementReferenceException(seatsSelectLocator);
        return this;
    }

    public AvtoslavaHomePage clickOnSubmitDrive() {
        findElementByLocatorAndClickStaleElementReferenceException(buttonSubmitDriveLocator);
        return this;
    }

    public AvtoslavaHomePage clickOnReserve() {
        findElementByLocatorAndClickStaleElementReferenceException(inputReserveLocator);
        return this;
    }

    public AvtoslavaHomePage clickOnTomorrow() {
        findElementByLocatorAndClickStaleElementReferenceException(buttonTomorrow);
        return this;
    }

    public WebElement findElementByLocatorAndClickStaleElementReferenceException(By locator) {
        try {
            WebElement element = findElementByLocator(locator);
            element.click();
            return element;
        } catch (StaleElementReferenceException e) {
            WebElement element = findElementByLocator(locator);
            element.click();
            return element;
        }
    }

    public String getTextFrom(By locator) {
        try {
            return findElementByLocator(locator).getText();
        } catch (StaleElementReferenceException e) {
            return findElementByLocator(locator).getText();
        }
    }

    public String getTextFromReserveResponse() {
        return getTextFrom(reserveFineLocator);
    }

    public WebElement findElementByLocator(By locator) {
        return new WebDriverWait(driver, TIMEOUT_IN_SECONDS)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }
}

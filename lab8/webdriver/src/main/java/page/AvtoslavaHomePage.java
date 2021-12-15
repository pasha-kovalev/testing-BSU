package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AvtoslavaHomePage extends AbstractPage {
    private static final Logger LOG = LogManager.getLogger(AvtoslavaHomePage.class);
    private static final String HOMEPAGE_URL = "https://avto-slava.by/";

    private final By buttonSubmitDriveLocator = By.xpath("//button[@class='btn btn-primary'][text()=' Оформить ']");

    private final By routeSelectLocator = By.xpath("//div[@class='route-buttons']" +
            "/select[@class='form-control ng-pristine ng-valid']/option[@value='1']");

    private final By buttonTomorrow = By.xpath("//button[@class='btn btn-sm btn-info'][text()='Послезавтра']");

    public AvtoslavaHomePage(WebDriver driver) {
        super(driver);
    }

    public AvtoslavaHomePage openHomePage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public AvtoslavaOrderPage clickOnSubmitDrive() {
        findElementByLocatorAndClickStaleElementReferenceException(buttonSubmitDriveLocator);
        return new AvtoslavaOrderPage(driver);
    }

    public AvtoslavaHomePage clickOnTomorrow() {
        findElementByLocatorAndClickStaleElementReferenceException(buttonTomorrow);
        return this;
    }

    public AvtoslavaHomePage selectRoute() {
        findElementByLocatorAndClickStaleElementReferenceException(routeSelectLocator);
        return this;
    }

    public List<WebElement> findElementsInPanelBy(String text) {
        return driver.findElements(By.xpath("//div[@class='panel panel-default']//*[contains(text(),'" + text + "')]"));
    }
}

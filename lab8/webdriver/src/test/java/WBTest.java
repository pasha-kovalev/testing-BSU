import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.AvtoslavaHomePage;


import java.io.File;

public class WBTest {
    public static final String NAME = "Павел";
    public static final String PHONE = "296742715";
    public static final String RESERVE_IS_FINE_MSG = "ВАШ ЗАКАЗ ПРИНЯТ!!!!\n" +
            "НАКАНУНЕ ПОЕЗДКИ С ВАМИ СВЯЖЕТСЯ ВОДИТЕЛЬ!!!!";
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        driver = new ChromeDriver(chromeOptions);
    }

    private final By reserveFineLocator = By.xpath("//div[@class='timetable-reservation-form-body']/" +
            "/h2");

    @Test
    public void placingAnOrder_withCorrectlyFilledOutFormAndAPhoneNumber() {
        AvtoslavaHomePage homePage = new AvtoslavaHomePage(driver);
        homePage.openHomePage().clickOnTomorrow();
        homePage.clickOnOformit();
        homePage.enterName(NAME);
        homePage.enterPhone(PHONE);
        homePage.selectStation();
        homePage.selectNumOfSeats();
        homePage.clickCheckBox();
        homePage.clickOnReserve();
        Assert.assertEquals(
                homePage.getTextFrom(reserveFineLocator),
                RESERVE_IS_FINE_MSG
        );
    }


    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser() {
        driver.quit();
    }

}

package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSingleton {
    private static WebDriver driver;

    private DriverSingleton(){}

    public static WebDriver getDriver(){
        if (null == driver){
            if ("firefox".equals(System.getProperty("browser"))) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                driver.manage().window().maximize();
                return driver;
            }

            WebDriverManager.chromedriver().version("94").setup();
            driver = new ChromeDriver(new ChromeOptions().setHeadless(false).setBinary("D:\\Shindows\\Programm Files\\Google\\Chrome\\Application\\chrome.exe"));
            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void closeDriver(){
        /*driver.quit();
        driver = null;*/
    }
}
package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSingleton {
    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            if ("firefox".equals(System.getProperty("browser"))) {
                WebDriverManager.firefoxdriver().version("95").setup();
                driver = new FirefoxDriver(new FirefoxOptions().addArguments("--headless", "--no-sandbox",
                        "--disable-dev-shm-usage", "--window-size=1920,1080", "--disable-extensions",
                        "--proxy-server='direct://'", "--proxy-bypass-list=*", "--start-maximized", "--disable-gpu",
                        "--ignore-certificate-errors"));
                driver.manage().window().maximize();
                return driver;
            }

            WebDriverManager.chromedriver().version("95").setup();
            driver = new ChromeDriver(new ChromeOptions().addArguments("--headless", "--no-sandbox",
                    "--disable-dev-shm-usage", "--window-size=1920,1080", "--disable-extensions",
                    "--proxy-server='direct://'", "--proxy-bypass-list=*", "--start-maximized", "--disable-gpu",
                    "--ignore-certificate-errors"));

            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
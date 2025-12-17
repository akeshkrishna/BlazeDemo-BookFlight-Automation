package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;

    public void setUp() {
        String browser = ConfigReader.get("browser");
        String url = ConfigReader.get("url");

        if ("chrome".equalsIgnoreCase(browser)) {
            driver = new ChromeDriver();
        } else {
            throw new RuntimeException("Only Chrome supported for now.");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // open BlazeDemo home page
        driver.get(url);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

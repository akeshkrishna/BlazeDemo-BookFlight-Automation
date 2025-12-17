package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    private WebDriver driver;

    private By fromPortSelect = By.name("fromPort");
    private By toPortSelect   = By.name("toPort");
    private By findFlightsBtn = By.cssSelector("input[type='submit']"); // "Find Flights"

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFromCity(String city) {
        new Select(driver.findElement(fromPortSelect)).selectByVisibleText(city);
    }

    public void selectToCity(String city) {
        new Select(driver.findElement(toPortSelect)).selectByVisibleText(city);
    }

    public void clickFindFlights() {
        driver.findElement(findFlightsBtn).click();
    }
}

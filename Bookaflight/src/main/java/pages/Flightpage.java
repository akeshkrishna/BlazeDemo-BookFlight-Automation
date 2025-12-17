package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Flightpage {

    private WebDriver driver;

    // first "Choose This Flight" button
    private By firstChooseFlightBtn = By.xpath("//table/tbody/tr[1]//input[@type='submit']");

    public Flightpage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseFirstFlight() {
        driver.findElement(firstChooseFlightBtn).click();
    }
}

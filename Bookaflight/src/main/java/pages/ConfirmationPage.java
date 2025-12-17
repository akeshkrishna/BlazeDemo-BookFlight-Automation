package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {

    private WebDriver driver;

    // first row, second cell = confirmation ID
    private By idCell = By.xpath("//table/tbody/tr[1]/td[2]");

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getConfirmationId() {
        return driver.findElement(idCell).getText();
    }
}

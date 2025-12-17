package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PurchasePage {

    private WebDriver driver;

    private By nameField       = By.id("inputName");
    private By addressField    = By.id("address");
    private By cityField       = By.id("city");
    private By stateField      = By.id("state");
    private By zipField        = By.id("zipCode");
    private By cardTypeSelect  = By.id("cardType");
    private By cardNumberField = By.id("creditCardNumber");
    private By purchaseBtn     = By.cssSelector("input[value='Purchase Flight']");

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillPassengerDetails(String name,
                                     String address,
                                     String city,
                                     String state,
                                     String zip,
                                     String cardType,
                                     String cardNumber) {

        driver.findElement(nameField).sendKeys(name);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(zipField).sendKeys(zip);

        new Select(driver.findElement(cardTypeSelect))
                .selectByVisibleText(cardType);

        driver.findElement(cardNumberField).sendKeys(cardNumber);
    }

    public void clickPurchase() {
        driver.findElement(purchaseBtn).click();
    }
}

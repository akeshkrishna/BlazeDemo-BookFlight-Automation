package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ConfirmationPage;
import pages.Flightpage;
import pages.HomePage;
import pages.PurchasePage;
import utils.ExcelUtils;

public class BookFlightTest extends BaseTest {

    @BeforeClass
    public void setUpTest() {
        setUp();   // opens browser, goes to BlazeDemo
    }

    @Test
    public void bookFlightUsingExcelData() throws InterruptedException {

        // 1. Read Excel data
        ExcelUtils excel = new ExcelUtils("FlightData.xlsx", "FlightData");

        String fromCity   = excel.getCellData(1, 0);
        String toCity     = excel.getCellData(1, 1);
        String name       = excel.getCellData(1, 2);
        String address    = excel.getCellData(1, 3);
        String city       = excel.getCellData(1, 4);
        String state      = excel.getCellData(1, 5);
        String zip        = excel.getCellData(1, 6);
        String cardType   = excel.getCellData(1, 7);
        String cardNumber = excel.getCellData(1, 8);

        // 2. Home page – search flights
        HomePage home = new HomePage(driver);
        home.selectFromCity(fromCity);
        home.selectToCity(toCity);
        home.clickFindFlights();

        // 3. Flights page – choose first flight
        Flightpage flights = new Flightpage(driver);
        flights.chooseFirstFlight();

        // 4. Purchase page – fill form and purchase
        PurchasePage purchase = new PurchasePage(driver);
        purchase.fillPassengerDetails(name, address, city, state, zip, cardType, cardNumber);
        purchase.clickPurchase();

        // 5. Confirmation page – verify confirmation ID
        ConfirmationPage conf = new ConfirmationPage(driver);
        String id = conf.getConfirmationId();
        System.out.println("Confirmation ID: " + id);
        Thread.sleep(3000);

        Assert.assertNotNull(id, "Confirmation ID should not be null");
        Assert.assertFalse(id.trim().isEmpty(), "Confirmation ID should not be empty");
    }

    @AfterClass
    public void tearDownTest() {
        tearDown();
    }
}

package Tests;


import Listeners.InvokedMethod;
import Listeners.Itest;
import Pages.Page1_HomePage;
import Pages.Page3_ProductPage;
import Pages.Page5_ShippingPage;
import Pages.Page7_PurchaseSuccessPage;
import Utilities.DataUtil;
import Utilities.LogsUtil;
import com.github.javafaker.Faker;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import static DriverFactory.driverFactory.*;
import static Utilities.DataUtil.getPropertiesData;

/**
 * Quits the WebDriver after each test.
 */
@Listeners({InvokedMethod.class, Itest.class})
public class TC3_CheckoutProcess {
    private final String ValidEmail = DataUtil.getJsonData("TestData", "Email_Address");
    private final String First_Name = new Faker().name().firstName();
    private final String Last_Name =  new Faker().name().lastName();
    private final String Company = DataUtil.getJsonData("TestData", "Company");
    private final String Street_Address = DataUtil.getJsonData("TestData", "Street_Address");
    private final String City = DataUtil.getJsonData("TestData", "City");
    private final String PostalCode = DataUtil.getJsonData("TestData", "Zip");
    private final String Country = DataUtil.getJsonData("TestData", "Country");
    private final String Phone_No = String.valueOf(new Faker().phoneNumber());
    public TC3_CheckoutProcess() throws FileNotFoundException {
    }
    /**
     * Sets up the WebDriver and navigates to the home page before each test.
     * @throws IOException if properties file cannot be read
     */
    @BeforeMethod
    public void setup() throws IOException {
        LogsUtil.info("Chrome Driver is opened");
        setupDriver(getPropertiesData("enviroments", "Browser"));
        getDriver().get(getPropertiesData("enviroments", "Home_URL"));
        LogsUtil.info("Page is redirected to url");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    /**
     * Test: Verifies the end-to-end checkout process.
     * Adds a product to the cart, proceeds through checkout, and asserts the purchase success message.
     * @throws IOException if there is an error during the test
     */
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void Valid_Checkout()
    {
        // Add product to cart
        new Page1_HomePage(getDriver())
                .click_on_Product_No(1)
                .Choose_Attributes("xs","second color")
                .Add_To_Cart();
        // Proceed to cart and checkout
        new Page3_ProductPage(getDriver()).Click_on_ShoppingCart()
                .Click_Proceed_toCheckout();
        // Complete checkout and place order
        new Page5_ShippingPage(getDriver()).Enter_EmailAddress(ValidEmail)
                .Enter_FirstName(First_Name)
                .Enter_LastName(Last_Name)
                .Enter_StreetAddress_firstField(Street_Address)
                .Enter_City(City)
                .Enter_ZipCode(PostalCode)
                .Choose_Country(Country)
                .Enter_PhoneNumber(Phone_No)
                .Click_Next("Flat Rate")
                .Click_Place_Order();

        // Assert that the order confirmation message is displayed
        Assert.assertTrue(new Page7_PurchaseSuccessPage(getDriver()).VisibilityOfThanksMessgage(),
            "Thanks message is not displayed, checkout process failed");
    }

    /**
     * Quits the WebDriver after each test.
     */
    @AfterMethod
    public void quit() {
        quitdriver();
    }
}

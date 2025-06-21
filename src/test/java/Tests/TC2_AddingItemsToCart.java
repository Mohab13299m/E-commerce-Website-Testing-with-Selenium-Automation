package Tests;

import Listeners.InvokedMethod;
import Listeners.Itest;
import Pages.Page1_HomePage;
import Pages.Page3_ProductPage;
import Utilities.LogsUtil;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.driverFactory.*;
import static Utilities.DataUtil.getPropertiesData;

/**
 * Test class for verifying adding items to the cart functionality.
 * Ensures that a product can be added to the cart successfully.
 */
@Listeners({InvokedMethod.class, Itest.class})
public class TC2_AddingItemsToCart {

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
     * Test: Verifies that a product can be added to the cart with valid attributes.
     * Asserts that the success message is displayed after adding the product.
     * @throws IOException if there is an error during the test
     */
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void Add_Item_to_cart_TC() throws IOException {
        new Page1_HomePage(getDriver())
                .click_on_Product_No(1)
                .Choose_Attributes("xs","second color")
                .Add_To_Cart();
        Assert.assertTrue(new Page3_ProductPage(getDriver()).Verify_Success_Message(),
                "Product was not added to cart successfully");
    }

    /**
     * Quits the WebDriver after each test.
     */
    @AfterMethod
    public void quit() {
        quitdriver();
    }
}

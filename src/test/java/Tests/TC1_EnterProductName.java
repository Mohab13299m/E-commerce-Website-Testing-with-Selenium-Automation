package Tests;


import Listeners.InvokedMethod;
import Listeners.Itest;
import Pages.Page1_HomePage;

import Utilities.DataUtil;
import Utilities.LogsUtil;
import io.qameta.allure.Description;
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
 * Test class for verifying invalid product search functionality.
 * Ensures that searching for a non-existent product displays the correct message.
 */
@Listeners({InvokedMethod.class, Itest.class})
public class TC1_EnterProductName {

    // Test data: invalid product name loaded from JSON test data
    private final String Invalid_Product=DataUtil.getJsonData("TestData", "Invalid_Product");
  //  private final String SQL_Injection = "' OR '1'='1";
 //   String xssPayload = "<script>alert('XSS')</script>";

    /**
     * Default constructor.
     * @throws FileNotFoundException if test data file is not found
     */
    public TC1_EnterProductName() throws FileNotFoundException {
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
     * Test: Verifies that searching for an invalid product name
     * displays the "no results" message.
     * @throws IOException if there is an error during the test
     */
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void InValid_Search_TC1() throws IOException {
        // Perform search and get the result message
        boolean msg = new Page1_HomePage(getDriver())
                .Search_Product_Name(Invalid_Product)
                .Enter_Search()
                .Visibility_Of_No_Result();
        System.out.println(msg);
        // Assert that the correct "no results" message is displayed
        Assert.assertTrue(msg, "'No results message' is not displayed for invalid product search");
                // .Checking_for_XSSInjection()
               // .Checking_for_SQLInjection();
        //Assert.assertTrue(msg, "SQL Injection is prevented");
        //Assert.assertFalse(msg, "XSS Injection is not prevented");
    }
    /**
     * Quits the WebDriver after each test.
     */
    @AfterMethod
    public void quit() {
        quitdriver();
    }
}
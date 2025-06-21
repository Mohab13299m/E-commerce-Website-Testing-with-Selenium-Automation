package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;


/**
 * Page Object representing the Shipping Page.
 * Provides methods to fill in shipping details, select shipping method, and proceed to payment.
 */
public class Page5_ShippingPage {
    private final WebDriver driver;

    // Locators for shipping form fields
    private final By Email_Address = By.xpath("(//input[@type='email'])[2]");
    private final By First_Name = By.xpath("//input[@name='firstname']");
    private final By Last_Name = By.xpath("//input[@name='lastname']");
    private final By Company = By.xpath("//input[@name='company']");
    private final By StreetAddress_First_Field = By.xpath("//input[@name='street[0]']");
    private final By StreetAddress_Second_Field = By.xpath("//input[@name='street[1]']");
    private final By StreetAddress_Third_Field = By.xpath("//input[@name='street[2]']");
    private final By City = By.xpath("//input[@name='city']");
    private final By State_DropDown = By.xpath("(//select[@class='select'])[1]");;
    private final By ZIP_Code = By.xpath("//input[@name='postcode']");
    private final By Country_DropDown = By.xpath("(//select[@class='select'])[2]");;
    private final By Phone_Number = By.xpath("//input[@name='telephone']");

    // Locators for shipping method and navigation
    private final By Next_Btn = By.xpath("//button[@data-role='opc-continue']");
    private final By Shipping_Method = By.xpath("//input[@type='radio']");


    /**
     * Constructor for Page5_ShippingPage.
     * @param driver the WebDriver instance to interact with the browser
     */
    public Page5_ShippingPage(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * Enters the email address in the shipping form.
     * @param email the email address to enter
     * @return the current Page5_ShippingPage instance for method chaining
     */
    public Page5_ShippingPage Enter_EmailAddress(String email) {
        Utility.senddata(driver, Email_Address, email);
        return this;
    }


    /**
     * Enters the first name in the shipping form.
     * @param name the first name to enter
     * @return the current Page5_ShippingPage instance for method chaining
     */
    public Page5_ShippingPage Enter_FirstName(String name) {
        Utility.senddata(driver, First_Name, name);
        return this;
    }


    /**
     * Enters the last name in the shipping form.
     * @param name the last name to enter
     * @return the current Page5_ShippingPage instance for method chaining
     */
    public Page5_ShippingPage Enter_LastName(String name) {
        Utility.senddata(driver, Last_Name, name);
        return this;
    }

    /**
     * Enters the company name in the shipping form.
     * @param company the company name to enter
     * @return the current Page5_ShippingPage instance for method chaining
     */
    public Page5_ShippingPage Enter_Company(String company) {
        Utility.senddata(driver, Company, company);
        return this;
    }

    /**
     * Enters the first line of the street address.
     * @param first_field the first line of the street address
     * @return the current Page5_ShippingPage instance for method chaining
     */
    public Page5_ShippingPage Enter_StreetAddress_firstField(String first_field) {
        Utility.senddata(driver, StreetAddress_First_Field, first_field);
        return this;
    }

    /**
     * Enters the second line of the street address.
     * @param second_field the second line of the street address
     * @return the current Page5_ShippingPage instance for method chaining
     */
    public Page5_ShippingPage Enter_StreetAddress_SecondField(String second_field) {
        Utility.senddata(driver, StreetAddress_Second_Field, second_field);
        return this;
    }

    /**
     * Enters the third line of the street address.
     * @param third_field the third line of the street address
     * @return the current Page5_ShippingPage instance for method chaining
     */
    public Page5_ShippingPage Enter_StreetAddress_ThirdField(String third_field) {
        Utility.senddata(driver, StreetAddress_Third_Field, third_field);
        return this;
    }

    /**
     * Enters the city in the shipping form.
     * @param city the city to enter
     * @return the current Page5_ShippingPage instance for method chaining
     */
    public Page5_ShippingPage Enter_City(String city) {
        Utility.senddata(driver, City, city);
        return this;
    }

    /**
     * Selects the state from the dropdown.
     * @param state the state to select
     * @return the current Page5_ShippingPage instance for method chaining
     */
    public Page5_ShippingPage Choose_State(String state) {
        Utility.SelectingFromDropdown(driver, State_DropDown, state);
        return this;
    }

    /**
     * Enters the ZIP code in the shipping form.
     * @param zip the ZIP code to enter
     * @return the current Page5_ShippingPage instance for method chaining
     */
    public Page5_ShippingPage Enter_ZipCode(String zip) {
        Utility.senddata(driver, ZIP_Code, zip);
        return this;
    }

    /**
     * Selects the country from the dropdown.
     * @param country the country to select
     * @return the current Page5_ShippingPage instance for method chaining
     */
    public Page5_ShippingPage Choose_Country(String country) {
        Utility.SelectingFromDropdown(driver, Country_DropDown, country);
        return this;
    }

    /**
     * Enters the phone number in the shipping form.
     * @param number the phone number to enter
     * @return the current Page5_ShippingPage instance for method chaining
     */
    public Page5_ShippingPage Enter_PhoneNumber(String number) {
        Utility.senddata(driver, Phone_Number, number);
        return this;
    }

    /**
     * Returns the number of available shipping methods.
     * @return the count of shipping method radio buttons
     */
    public int Shipping_Method() {
        return driver.findElements(By.xpath("//input[@type='radio']")).size();
    }

    /**
     * Selects the shipping method and clicks the Next button to proceed to the payment page.
     * @param shippingMethod the shipping method to select (e.g., "Best way", "flat rate")
     * @return a new Page6_PaymentMethodPage instance representing the payment method page
     */
    public Page6_PaymentMethodPage Click_Next(String shippingMethod) {
        if (Shipping_Method() == 1) {
            Utility.GeneralWait(driver).until(ExpectedConditions.elementToBeClickable(Next_Btn)).click();
        } else {
            switch (shippingMethod.toLowerCase()) {
                case "best way":
                    Utility.clickonElement(driver, By.xpath("(//input[@type='radio'])[1]"));
                    break;
                case "flat rate":
                    Utility.clickonElement(driver, By.xpath("(//input[@type='radio'])[2]"));
                    break;
            }
            Utility.GeneralWait(driver).until(ExpectedConditions.elementToBeClickable(Next_Btn)).click();
        }
        return new Page6_PaymentMethodPage(driver);
    }
}

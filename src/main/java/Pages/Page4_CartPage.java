package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



/**
 * Page Object representing the Shopping Cart Page.
 * Provides methods to proceed to the shipping page from the cart.
 */
public class Page4_CartPage {
    private final WebDriver driver;
    // Locator for the "Proceed to Checkout" button in the cart
    private final By Proceed_toCheckout_Button = By.cssSelector(".checkout-methods-items .action.primary.checkout");

    /**
     * Constructor for Page4_CartPage.
     * @param driver the WebDriver instance to interact with the browser
     */
    public Page4_CartPage(WebDriver driver) {
        this.driver=driver;
    }

    /**
     * Clicks the "Proceed to Checkout" button to navigate to the shipping page.
     * @return a new Page5_ShippingPage instance representing the shipping page
     */
    public Page5_ShippingPage Click_Proceed_toCheckout()
    {
        Utility.clickonElement(driver,Proceed_toCheckout_Button);
        return new Page5_ShippingPage(driver);
    }
}

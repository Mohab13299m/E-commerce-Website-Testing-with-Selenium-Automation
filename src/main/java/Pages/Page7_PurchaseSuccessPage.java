package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Clicks the "Place Order" button after waiting for the loader to disappear.
 * @return a new Page7_PurchaseSuccessPage instance representing the purchase success page
 */
public class Page7_PurchaseSuccessPage {
    private final WebDriver driver;

    // Locator for the "Thank You" message on the purchase success page
    private By Thanks_Message = By.tagName("h1");


    /**
     * Constructor for Page7_PurchaseSuccessPage.
     * @param driver the WebDriver instance to interact with the browser
     */
    public Page7_PurchaseSuccessPage(WebDriver driver) {
        this.driver=driver;
    }

    /**
     * Gets the order confirmation message displayed on the success page.
     * @return the confirmation message as a String
     */
    public boolean VisibilityOfThanksMessgage() {

        try{
            return Utility.bytoWebelement(driver, Thanks_Message).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}

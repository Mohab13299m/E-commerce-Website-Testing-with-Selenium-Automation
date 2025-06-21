package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Page6_PaymentMethodPage {
    private final WebDriver driver;

    // Locator for the "Place Order" button
    private final By Place_order_btn= By.xpath("//button[@title='Place Order']");

    // Locator for the loading mask/loader
    private final By loader = By.cssSelector(".loading-mask"); // Change selector to match your loader

    /**
     * Constructor for Page6_PaymentMethodPage.
     * @param driver the WebDriver instance to interact with the browser
     */
    public Page6_PaymentMethodPage(WebDriver driver) {
        this.driver=driver;
    }

    /**
     * Clicks the "Place Order" button after waiting for the loader to disappear.
     * @return a new Page7_PurchaseSuccessPage instance representing the purchase success page
     */
    public Page7_PurchaseSuccessPage Click_Place_Order()
    {
        Utility.GeneralWait(driver)
                .until(ExpectedConditions.invisibilityOfElementLocated(loader));

        Utility.GeneralWait(driver).
                until(ExpectedConditions.elementToBeClickable(Place_order_btn)).click();
        return new Page7_PurchaseSuccessPage(driver);
    }
}

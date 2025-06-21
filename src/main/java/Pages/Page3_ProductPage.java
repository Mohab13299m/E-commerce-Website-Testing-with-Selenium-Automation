package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Page Object representing the Product Details Page.
 * Provides methods to select product attributes, add the product to the cart, and navigate to the shopping cart.
 */
public class Page3_ProductPage {
    private final WebDriver driver;

    // Locators for product attributes and actions

    private  By Size;

    private  By Color;

    private final By Add_To_Cart_Button = By.id("product-addtocart-button");
    private static final By Product_Added_Msg = By.xpath("//div[contains(@class,'message-success')]");
    private static final By ShoppingCart = By.xpath("//a[text()='shopping cart']");
    private static final By ViewAndEdit_Cart = By.xpath("//a[contains(@class,'viewcart')]");

    private final By Proceed_toCheckout_Button = By.id("#top-cart-btn-checkout");


    /**
     * Constructor for Page3_ProductPage.
     * @param driver the WebDriver instance to interact with the browser
     */
    public Page3_ProductPage(WebDriver driver) {
        this.driver=driver;
    }


    /**
     * Selects the specified size and color for the product.
     * @param size the size to select (e.g., "xs", "s", "m", "l", "xl")
     * @param color the color to select (e.g., "first color", "second color", "third color")
     * @return the current Page3_ProductPage instance for method chaining
     */
    public Page3_ProductPage Choose_Attributes(String size,String color)
    {
        switch (size.toLowerCase())
        {
            case "xs":
                Size = By.id("option-label-size-143-item-166");
                break;
            case "s":
                Size = By.id("option-label-size-143-item-167");
                break;
            case "m":
                break;
            case "l":
                Size = By.id("option-label-size-143-item-169");
                break;
            case "xl":
                Size = By.id("option-label-size-143-item-170");
                break;
        }
        switch (color.toLowerCase())
        {
            case "first color":
                Color = By.id("option-label-color-93-item-50");
                break;
            case "second color":
                Color = By.id("option-label-color-93-item-53");
                break;
            case "third color":
                Color = By.id("#option-label-color-93-item-54");
                break;
        }
        Utility.clickonElement(driver,Size);
        Utility.clickonElement(driver,Color);
        return this;
    }

    /**
     * Clicks the "Add to Cart" button to add the product to the shopping cart.
     * @return the current Page3_ProductPage instance for method chaining
     */
    public Page3_ProductPage Add_To_Cart()
    {
        Utility.clickonElement(driver,Add_To_Cart_Button);
        return this;
    }

    /**
     * Clicks on the shopping cart link to navigate to the cart page.
     * @return a new Page4_CartPage instance representing the shopping cart page
     */
    public Page4_CartPage Click_on_ShoppingCart()
    {
        Utility.GeneralWait(driver).
                until(ExpectedConditions.
                        visibilityOfElementLocated(ShoppingCart)).click();
        return new Page4_CartPage(driver);
    }

    /**
     * Verifies if the success message for adding a product to the cart is displayed.
     * @return true if the success message is visible, false otherwise
     */
    public boolean Verify_Success_Message()
    {
       try{
           return Utility.bytoWebelement(driver, Product_Added_Msg).isDisplayed();
       }catch (Exception e) {
           return false;
       }
    }


}

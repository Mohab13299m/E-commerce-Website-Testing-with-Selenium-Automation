package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object representing the Home Page.
 * Provides methods to interact with products and navigation elements.
 */
public class Page1_HomePage {

    private final WebDriver driver;


    // Locator for the search box on the home page
    private final By Search_Box = By.id("search");


    /**
     * Constructor for Page1_HomePage.
     * @param driver the WebDriver instance to interact with the browser
     */
    public Page1_HomePage(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * Enters the given product name into the search box.
     * @param name the product name to search for
     * @return the current Page1_HomePage instance for method chaining
     */
    public Page1_HomePage Search_Product_Name(String name) {
        Utility.senddata(driver, Search_Box, name);
        return this;
    }


    /**
     * Presses Enter in the search box to perform the search.
     * @return a new Page2_SearchResult instance representing the search results page
     */
    public Page2_SearchResult Enter_Search() {
        Utility.Press_Enter(driver,Search_Box);
        return new Page2_SearchResult(driver);
    }

    /**
     * Clicks on the product at the specified index.
     * @param productNo the product number to click
     * @return this page object for chaining
     */
    public Page3_ProductPage click_on_Product_No(int productNo)
    {
        By Product = By.xpath("(//div[contains(@class,'product-item-info')])[" + productNo + "]");
        Utility.clickonElement(driver, Product);
        return new Page3_ProductPage(driver);
    }
}

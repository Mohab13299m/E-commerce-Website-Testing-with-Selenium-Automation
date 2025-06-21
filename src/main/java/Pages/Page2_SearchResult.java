package Pages;

import Utilities.Utility;
import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Page2_SearchResult {

    private final WebDriver driver;

    // Locator for the "no search result" notification

    private final By No_Search_Result = By.xpath("//div[contains(@class,'notice')]");

    // Locator for all product items in the search results

    private final By Search_Results = By.xpath("//div[contains(@class,'product-item-info')]");

    /**
     * Constructor for Page2_SearchResult.
     * @param driver the WebDriver instance to interact with the browser
     */
    public Page2_SearchResult(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Returns the number of products found in the search results.
     * @return the count of product items
     */
    public int Size_Of_Products()
    {
        return driver.findElements(Search_Results).size();
    }

    /**
     * Gets the text of the "no search result" notification.
     * @return the notification message as a String
     */

    public boolean Visibility_Of_No_Result() {
        try {
            return Utility.bytoWebelement(driver, No_Search_Result).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * Checks if the page source contains an XSS injection alert.
     * @return true if XSS alert is found, false otherwise
     */
    public boolean Checking_for_XSSInjection(){
     try{
         return  driver.getPageSource().contains("alert('XSS')");
     } catch (Exception e) {
         return false;
     }
    }

    /**
     * Checks if the page body contains evidence of SQL injection.
     * @return true if SQL-related text is found, false otherwise
     */
    public boolean Checking_for_SQLInjection(){
       try {
           String bodyText = Utility.GetText(driver, By.tagName("body")).toLowerCase();
           return bodyText.contains("sql");
       } catch (Exception e) {
           return false;
       }
    }

}

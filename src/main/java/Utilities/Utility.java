package Utilities;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
/**
 * Utility class for common WebDriver actions such as clicking, typing, and taking screenshots.
 */
public class Utility {
    private static final String screenshotsPath = "TestOutputs/Screenshots/";

    /**
     * Clicks on a web element located by the given locator.
     * @param driver The WebDriver instance.
     * @param locator The By locator of the element to click.
     */
    public static void clickonElement(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }
    /**
     * Types the given text into a web element located by the given locator.
     * @param driver The WebDriver instance.
     * @param locator The By locator of the element.
     * @param data The text to type.
     */
    public static void senddata(WebDriver driver, By locator, String data) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(data);
    }
    /**
     * Gets the text of a web element located by the given locator.
     * @param driver The WebDriver instance.
     * @param locator The By locator of the element.
     * @return The text of the element.
     */
    public static String GetText(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));

        return driver.findElement(locator).getText();
    }


    //TODO: Selecting from dropdown
    public static void SelectingFromDropdown(WebDriver driver, By dropdown, String Option) {
        new Select(bytoWebelement(driver, dropdown)).selectByVisibleText(Option);
    }

    //TODO: Taking ScreenShots
    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd-h-m-ssa").format(new Date());
    }

    /**
     * Takes a screenshot of the current browser window.
     * @param driver The WebDriver instance.
     */
    public static void takeScreenshots(WebDriver driver, String ScreenshotName) throws IOException {
        try {
            //Capture Screenshot
            File ScreenSrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //Save screenshot to a file
            File screenDest = new File(screenshotsPath + ScreenshotName + "-" + getTimeStamp() + ".png");
            FileUtils.copyFile(ScreenSrc, screenDest);
            //attach Screen shot to allure
            Allure.addAttachment(ScreenshotName, Files.newInputStream(Path.of(screenDest.getPath())));

        } catch (Exception e) {
            LogsUtil.Error(e.getMessage());
        }
    }

    /**
     * Presses the Enter key on a web element located by the given locator.
     * @param driver The WebDriver instance.
     * @param locator The By locator of the element.
     */
    public static void Press_Enter(WebDriver driver, By locator)
    {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    //TODO: Converting To by to WebElement
    public static WebElement bytoWebelement(WebDriver driver, By loc) {
        return driver.findElement(loc);
    }

    //TODO: General Wait
    public static WebDriverWait GeneralWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

}

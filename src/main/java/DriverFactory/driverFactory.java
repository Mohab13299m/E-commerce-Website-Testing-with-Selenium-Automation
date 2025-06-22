// Factory class for managing WebDriver instances using ThreadLocal for thread safety
package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.nio.file.Paths;

public class driverFactory {
    // ThreadLocal to ensure each thread has its own WebDriver instance

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    /**
     * Initializes the WebDriver based on the specified browser name.
     * Supports Chrome, Firefox, and Edge browsers.
     * @param browser The name of the browser to use ("chrome", "firefox", or others for Edge).
     */
    public static void setupDriver(String browser)
    {
        switch (browser.toLowerCase()){
            case "chrome":
                ChromeOptions chromeoptions = new ChromeOptions();
                chromeoptions.addExtensions(new File("extensions/ublock_lite.crx"));// Add uBlock Lite extension
                chromeoptions.addArguments("--start-maximized"); // it will open the browser in Maxmize
                driverThreadLocal.set(new ChromeDriver(chromeoptions));
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driverThreadLocal.set(new FirefoxDriver());
                break;
            default:
                EdgeOptions edgeoptions = new EdgeOptions();
                edgeoptions.addExtensions(new File("extensions/ublock_lite.crx"));
                edgeoptions.addArguments("--start-maximized");// it will open the browser in Maxmize mode
                driverThreadLocal.set(new EdgeDriver(edgeoptions));
        }
    }

    /**
     * Retrieves the WebDriver instance for the current thread.
     * @return The current thread's WebDriver instance.
     */
    public static WebDriver getDriver()
    {
      return   driverThreadLocal.get();
    }

    /**
     * Quits the WebDriver and removes it from the ThreadLocal storage.
     * Ensures proper cleanup after test execution.
     */
    public static void quitdriver() {
        getDriver().quit();
        driverThreadLocal.remove();
    }
}

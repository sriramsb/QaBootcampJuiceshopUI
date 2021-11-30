package com.qabootcamp.driver;

import com.qabootcamp.utils.ReadPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver(String browser) throws Exception {
        if (driver==null)
        {
        switch (browser) {
            case "IE":
                WebDriverManager.iedriver().setup();
                driver= new InternetExplorerDriver();
                break;
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "REMOTE":
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", "chrome");

                try {
                    driver= new RemoteWebDriver(new URL(ReadPropertyFile.getProperty("huburl")),
                            capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--headless");
                driver= new ChromeDriver(options);
                break;
            }
        }
        return driver;
    }


    public static void quitDriver() throws Exception {
        if(driver!=null) {
            driver.quit();
            driver=null;
        }
    }
}

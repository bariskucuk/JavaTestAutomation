package com.sociotestautomation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Browser {
    public static RemoteWebDriver driver;
    public static Properties prop;
    public static DesiredCapabilities caps;
    public static Actions builder;

    public static final String AUTOMATE_USERNAME = "alihanozbayrak1";
    public static final String AUTOMATE_ACCESS_KEY = "yYzukxkJ3sAqxT1pyW7B";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public Browser(){}


    public static void initialization() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/sociotestautomation" +
                    "/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        caps = new DesiredCapabilities();
        caps.setCapability("os_version", prop.getProperty("os_version"));
        caps.setCapability("resolution", prop.getProperty("resolution"));
        caps.setCapability("browser", prop.getProperty("browser"));
        caps.setCapability("browser_version", prop.getProperty("browser_version"));
        caps.setCapability("os", prop.getProperty("os"));
        caps.setCapability("name", prop.getProperty("name"));
        caps.setCapability("build", prop.getProperty("build"));

        URL remoteDriver= null;
        try {
            remoteDriver = new URL(URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new RemoteWebDriver(remoteDriver, caps);
        driver.setFileDetector(new LocalFileDetector());
        builder = new Actions(driver);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get(prop.getProperty("url"));
    }

    public static void openNewWindowAndNavigateToUrl(String url)
    {
        Browser.driver.switchTo().newWindow(WindowType.WINDOW);
        Browser.driver.get(url);
        driver.manage().window().maximize();
    }

    public static void getToWindow(String windowHandle)
    {
            for (String windowHandleItem : driver.getWindowHandles()) {
                if (windowHandle.contentEquals(windowHandleItem)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
    }
}


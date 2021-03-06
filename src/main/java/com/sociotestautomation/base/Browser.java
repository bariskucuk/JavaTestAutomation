package com.sociotestautomation.base;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class Browser {
    public static RemoteWebDriver driver;
    public static Properties prop;
    public static DesiredCapabilities caps;
    public static Actions builder;

    public static String AUTOMATE_USERNAME;
    public static String AUTOMATE_ACCESS_KEY;
    public static String URL;

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

        AUTOMATE_USERNAME = prop.getProperty("browserstack_Username");
        AUTOMATE_ACCESS_KEY = prop.getProperty("browserstack_Access_Key");
        URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

        URL remoteDriver = null;
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


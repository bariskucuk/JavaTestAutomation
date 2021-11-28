package com.sociotestautomation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Browser {
    public static WebDriver driver;
    public static Properties prop;

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
        String browserName = prop.getProperty("browser");
        int pageLoadTimeout =  Integer.parseInt(prop.getProperty("pageLoadTimeout"));
        int implicitWait = Integer.parseInt(prop.getProperty("implicitWait"));

        if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }

    public static void openNewWindowAndNavigateToUrl(String url)
    {
        Browser.driver.switchTo().newWindow(WindowType.WINDOW);
        Browser.driver.get(url);
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


package com.sociotestautomation.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.sociotestautomation.base.Browser.driver;
import static com.sociotestautomation.base.Browser.initialization;

public class TestBase {
    @BeforeMethod
    public void setUp() {
        initialization();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public static void markTestStatus(String status, String reason, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
    }
}

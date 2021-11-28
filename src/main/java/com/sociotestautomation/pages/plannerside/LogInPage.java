package com.sociotestautomation.pages.plannerside;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LogInPage {
    public static Properties prop;
    public static String EmailConfig;
    public static String PassConfig;

    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement Email;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement Password;

    @FindBy(xpath = "//button[@data-testid=\"btnLogin\"]")
    WebElement LoginButton;

    public void populateEmail()
    {
        Email.sendKeys(EmailConfig);
    }

    public void populatePassword()
    {
        Password.sendKeys(PassConfig);
    }

    public void LogIn()
    {
        readEmailAndPassword();
        populateEmail();
        populatePassword();
        LoginButton.click();
    }

    public void readEmailAndPassword(){
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
        EmailConfig = prop.getProperty("email");
        PassConfig = prop.getProperty("password");
    }
}

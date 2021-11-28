package com.sociotestautomation.pages.attendeeside;
import com.sociotestautomation.base.Browser;
import com.sociotestautomation.pages.plannerside.LogInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebAppLogInPage {
    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement Email;

    @FindBy(xpath = "//*[@id=\"continue-button\"]")
    WebElement ContinueButton;

    @FindBy(xpath = "//*[@id=\"password-input\"]")
    WebElement Password;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    WebElement LoginButton;


    public void logIn()
    {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Email.sendKeys(LogInPage.EmailConfig);
        ContinueButton.click();
        /*WebDriverWait wait = new WebDriverWait(Browser.driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated();*/
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Password.sendKeys(LogInPage.PassConfig);
        LoginButton.click();
    }
}

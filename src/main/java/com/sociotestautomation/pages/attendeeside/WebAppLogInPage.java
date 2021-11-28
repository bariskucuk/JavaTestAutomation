package com.sociotestautomation.pages.attendeeside;
import com.sociotestautomation.pages.plannerside.LogInPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        Email.sendKeys(LogInPage.EmailConfig);
        ContinueButton.click();
        Password.sendKeys(LogInPage.PassConfig);
        LoginButton.click();
    }
}

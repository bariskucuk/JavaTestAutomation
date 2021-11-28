package com.sociotestautomation.pages.plannerside;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {

    @FindBy(xpath = "//a[@data-testid=\"linkLogin\"]")
    WebElement LoginLink;

    public void clickLogInLink()
    {
        LoginLink.click();
    }
}

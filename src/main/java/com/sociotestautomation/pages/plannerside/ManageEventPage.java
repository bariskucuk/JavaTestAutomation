package com.sociotestautomation.pages.plannerside;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class ManageEventPage {

    @FindBy(linkText = "Web App")
    WebElement WebApp;

    @FindBy(linkText = "Edit Event")
    WebElement EditEvent;

    public void clickWebApp()
    {
        try {
            WebApp.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebApp.click();
        }
    }

    public void clickEditEvent()
    {
        try {
            EditEvent.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            EditEvent.click();
        }
    }

}

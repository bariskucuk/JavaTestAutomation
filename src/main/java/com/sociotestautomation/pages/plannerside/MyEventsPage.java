package com.sociotestautomation.pages.plannerside;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class MyEventsPage {
    @FindBy(xpath = "//h3[text()=\"Test Automation Assessment Event\"]")
    WebElement EventName;

    public void clickEvent()
    {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        EventName.click();
    }
}

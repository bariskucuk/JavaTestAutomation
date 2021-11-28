package com.sociotestautomation.pages.plannerside;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class MyEventsPage {
    @FindBy(xpath = "//h3[text()=\"Test Automation Assessment Event\"]")
    WebElement EventName;

    //@FindBy(xpath = "//*[@id=\"rs-wrapper\"]/article/div/div/div[2]/div/div/div/div[2]/div/h3")

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

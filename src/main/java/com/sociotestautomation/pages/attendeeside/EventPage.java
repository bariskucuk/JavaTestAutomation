package com.sociotestautomation.pages.attendeeside;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class EventPage {
    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div/div/div[2]/ul/div[5]/div[2]")
    WebElement Wall;


    ///@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div/div/div[2]/ul/div[5]")
//*[@id="root"]/div[2]/div[2]/div/div[2]/div/div/div[2]/ul/div[5]/div[2]

    public void clickWall() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Wall.click();
    }
}

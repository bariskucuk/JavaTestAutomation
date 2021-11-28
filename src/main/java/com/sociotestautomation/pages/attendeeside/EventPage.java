package com.sociotestautomation.pages.attendeeside;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class EventPage {

    @FindBy(xpath = "//div[@data-testid='listItem'][4]")
    WebElement Wall;

    public void clickWall() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Wall.click();
    }
}

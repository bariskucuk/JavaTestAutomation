package com.sociotestautomation.pages.attendeeside;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class EventPage {
    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div/div/div[2]/ul/div[5]")
    WebElement Wall;

    public void clickWall() {
        Wall.click();

    }
}

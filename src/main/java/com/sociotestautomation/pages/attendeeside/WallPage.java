package com.sociotestautomation.pages.attendeeside;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class WallPage {
    public static String postText;
    @FindBy(xpath = "//div[@data-testid=\"new-post-text\"]")
    WebElement NewPostLink;

    @FindBy(xpath = "//div[@data-testid=\"post-modal-input\"]/div/textarea[3]")
    WebElement NewPostText;

    @FindBy(xpath = "//div[@data-testid=\"post-modal-add-image\"]")
    WebElement AddImage;

    @FindBy(xpath = "//input[@id=\"fsp-fileUpload\"]")
    WebElement FileUpload;

    @FindBy(xpath = "//span[@title=\"Save\"]")
    WebElement SaveImage;

    @FindBy(xpath = "//span[@title=\"Upload\"]")
    WebElement UploadImage;

    @FindBy(xpath = "//button[@data-testid=\"post-modal-send\"]")
    WebElement SendPost;

    public void clickNewPostLink()
    {
        NewPostLink.click();
    }
    public void setNewPostText()
    {
        postText = UUID.randomUUID().toString();

        NewPostText.sendKeys(postText);
    }

    public void AddImage()
    {
        AddImage.click();
    }

    public void AddNewPost()
    {
        clickNewPostLink();
        setNewPostText();
        AddImage();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        FileUpload.sendKeys(System.getProperty("user.dir") +"/data/SocioSymbol.png");
        SaveImage.click();
        UploadImage.click();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SendPost.click();
    }
}

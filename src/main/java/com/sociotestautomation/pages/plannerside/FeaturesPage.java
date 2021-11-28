package com.sociotestautomation.pages.plannerside;
import com.sociotestautomation.base.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class FeaturesPage {

    @FindBy(xpath = "//button[@data-testid=\"buttonEditFeature\"]")
    WebElement EditWallButton;

    @FindBy(xpath = "//h4[text()=\"Wall\"]")
    WebElement WallButton;

    @FindBy(xpath = "//*[@id=\"componentItemsList\"]/div/div[1]/div[2]/div/div/span")
    WebElement FirstItemText;

    @FindBy(xpath = "//*[@id=\"dropdown-button\"]")
    WebElement DropDownButton;

    @FindBy(xpath = "//a[text()=\"Delete\"]")
    WebElement DeleteButton;

    @FindBy(xpath = "//a[text()=\"Delete\"]")
    WebElement YesButtonToConfirmDelete;

    public String getFirstItemText()
    {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return FirstItemText.getText();
    }
    public void clickWallEditButton(){
        try {
            Browser.builder.moveToElement(WallButton).perform();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            Browser.builder.moveToElement(WallButton).perform();
        }

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        EditWallButton.click();
    }

    public void DeleteAWallPost(){
        DropDownButton.click();
        DeleteButton.click();
        YesButtonToConfirmDelete.click();
    }
}

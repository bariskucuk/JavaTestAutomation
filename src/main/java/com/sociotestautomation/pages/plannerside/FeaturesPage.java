package com.sociotestautomation.pages.plannerside;
import com.sociotestautomation.base.Browser;
import com.sociotestautomation.pages.attendeeside.WallPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class FeaturesPage {

    @FindBy(xpath = "//button[@data-testid=\"buttonEditFeature\"]")
    WebElement EditWallButton;

    @FindBy(xpath = "//h4[text()=\"Wall\"]")
    WebElement WallButton;

    @FindBy(xpath = "//button[@id=\"dropdown-button\"]")
    WebElement DropDownButton;

    @FindBy(xpath = "//a[text()=\"Delete\"]")
    WebElement DeleteButton;

    @FindBy(xpath = "//button[text()=\"Yes\"]")
    WebElement YesButtonToConfirmDelete;

    WebElement SearchItem;

    public boolean isItemInTheList(String SearchString)
    {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            SearchItem = Browser.driver.findElement(By.xpath("//span[@title=\""+ WallPage.postText +"\"]"));
        } catch (NoSuchElementException e)
        {
            return false;
        }

        return true;
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
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DropDownButton.click();

        JavascriptExecutor jse = (JavascriptExecutor) Browser.driver;
        jse.executeScript("arguments[0].click();", DeleteButton);
        YesButtonToConfirmDelete.click();
    }
}

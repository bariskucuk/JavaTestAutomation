package com.sociotestautomation.pages.plannerside;

import com.sociotestautomation.base.Browser;
import com.sociotestautomation.pages.attendeeside.WallPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

public class WebAppPage {
    String copiedLink;

    @FindBy(xpath = "//div[@class=\"panel-body\"]/div[5]/div[1]/span/span/button")
    WebElement CopyLink;

    @FindBy(xpath = "//div[@class=\"panel-body\"]/div[5]/div[1]/span/input")
    WebElement ShareAbleLinkText;

    @FindBy(xpath = "//button[text()=\"Save\"]")
    WebElement SaveButton;

    public void clickSave()
    {
        SaveButton.click();
    }
    public void enableWebApp()
    {
        List<WebElement> switchElements;

        switchElements = Browser.driver.findElements(By.xpath("//div[contains(@class,\"bootstrap-switch-off\")]"));

        try {
            if(switchElements.size()>1)
                switchElements.get(0).click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            if(switchElements.size()>1)
                switchElements.get(0).click();
        }
        catch (NoSuchElementException e)
        {
        }

    }

    public void getSharableLink()
    {
        CopyLink.click();
    }

    public void openWebAppUsingShareableLink()
    {
        /*
        try {
            copiedLink= (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (HeadlessException e) {
            e.printStackTrace();
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        copiedLink = ShareAbleLinkText.getAttribute("value");
        Browser.openNewWindowAndNavigateToUrl(copiedLink);
    }
}

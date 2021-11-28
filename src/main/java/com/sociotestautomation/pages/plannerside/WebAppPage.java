package com.sociotestautomation.pages.plannerside;

import com.sociotestautomation.base.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class WebAppPage {
    String copiedLink;
    @FindBy(xpath = "//div[@class=\"panel-body\"]/div[2]/div/div/div/div/div/span[1]")
    WebElement IsWebAppEnabled;

    @FindBy(xpath = "//div[@class=\"panel-body\"]/div[5]/div[1]/span/span/button")
    WebElement CopyLink;

    @FindBy(xpath = "//div[@class=\"panel-body\"]/div[5]/div[1]/span/input")
    WebElement ShareAbleLinkText;

    public void enableWebApp()
    {
        try {
            IsWebAppEnabled.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            IsWebAppEnabled.click();
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

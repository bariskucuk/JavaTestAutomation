package com.sociotestautomation.pages.plannerside;
import com.sociotestautomation.base.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class FeaturesPage {

    @FindBy(xpath = "//a[@data-testid=\"buttonEditFeature\"]")
    WebElement EditWallButton;

    public void clickWallEditButton(){
        EditWallButton.click();
    }
}

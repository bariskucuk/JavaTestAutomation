package com.sociotestautomation.testcases;

import com.sociotestautomation.base.Browser;
import com.sociotestautomation.pages.attendeeside.WallPage;
import com.sociotestautomation.pages.plannerside.PlannerPages;
import com.sociotestautomation.pages.attendeeside.AttendeePages;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

import static com.sociotestautomation.base.Browser.driver;

public class AddNewPostToWallTest extends TestBase {
    boolean newPostAddedSuccessfully;
    @BeforeClass
    public void Setup()
    {

    }

    @Test(priority = 0, description = "Add a new post to wall with image", groups = {"FunctionalTest", "Group1"})
    public void addNewPostToWallTest() {
        String plannerWindow = driver.getWindowHandle();

        PlannerPages.singUpPage().clickLogInLink();
        PlannerPages.logInPage().LogIn();
        PlannerPages.myEventsPage().clickEvent();
        PlannerPages.manageEventPage().clickWebApp();
        PlannerPages.webAppPage().enableWebApp();
        PlannerPages.webAppPage().clickSave();
        PlannerPages.webAppPage().getSharableLink();
        PlannerPages.webAppPage().openWebAppUsingShareableLink();
        AttendeePages.webAppLogInPage().logIn();
        AttendeePages.eventPage().clickWall();
        AttendeePages.wallPage().AddNewPost();
        Browser.getToWindow(plannerWindow);
        PlannerPages.manageEventPage().clickEditEvent();
        PlannerPages.featuresPage().clickWallEditButton();
        Assert.assertTrue(PlannerPages.featuresPage().isItemInTheList(AttendeePages.wallPage().postText));
        newPostAddedSuccessfully=true;
        TestBase.markTestStatus("passed","A new post to wall with image is successfully added!",driver);

    }

    @AfterMethod
    public void TearDown(ITestResult result){
        if(ITestResult.FAILURE==result.getStatus()){
            TestBase.markTestStatus("failed","A new post to wall with image test is failed!",driver);
        }
        //TO remove the wall post if it is added successfully
        if(newPostAddedSuccessfully)
        {
            Browser.driver.findElement(By.xpath("//span[@title=\""+ WallPage.postText +"\"]")).click();
            PlannerPages.featuresPage().DeleteAWallPost();
            Browser.driver.findElement(By.xpath("//button[@class=\"close\"]")).click();
        }
        driver.quit();
    }
}

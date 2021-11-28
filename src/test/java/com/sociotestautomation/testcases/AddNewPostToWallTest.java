package com.sociotestautomation.testcases;

import com.sociotestautomation.base.Browser;
import com.sociotestautomation.pages.plannerside.PlannerPages;
import com.sociotestautomation.pages.attendeeside.AttendeePages;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.TakesScreenshot;
import static com.sociotestautomation.base.Browser.driver;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class AddNewPostToWallTest extends TestBase {
    boolean newPostAddedSuccessfully;
    @BeforeClass
    public void Setup()
    {

    }

    @Test(priority = 0, description = "Add a new post to wall with image", groups = {"FunctionalTest", "Group1"})
    public void addNewPostToWallTest() {
        String plannerWindow = driver.getWindowHandle();
        //Logging.logger.info("TEST STARTED");
        PlannerPages.singUpPage().clickLogInLink();
        PlannerPages.logInPage().LogIn();
        PlannerPages.myEventsPage().clickEvent();
        PlannerPages.manageEventPage().clickWebApp();
        PlannerPages.webAppPage().enableWebApp();
        PlannerPages.webAppPage().getSharableLink();
        PlannerPages.webAppPage().openWebAppUsingShareableLink();
        AttendeePages.webAppLogInPage().logIn();
        AttendeePages.eventPage().clickWall();
        AttendeePages.wallPage().AddNewPost();
        Browser.getToWindow(plannerWindow);
        PlannerPages.manageEventPage().clickEditEvent();
        PlannerPages.featuresPage().clickWallEditButton();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Assert.assertTrue(Pages.registrationPage().formSuccessfullySubmitted(), "Yeni kullanıcı oluşturma hata verdi.");
        newPostAddedSuccessfully=true;
        //Logging.logger.info("TEST ENDED");
    }

    @AfterMethod
    public void TearDown(ITestResult result){
        if(ITestResult.FAILURE==result.getStatus()){
            try{
                TakesScreenshot screenshot=(TakesScreenshot) driver;
                File src=screenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(src, new File(System.getProperty("user.dir") +"/screenshot/"+result.getName()+".png"));
                //Logging.logger.info("Ekran goruntusu alindi");
            }catch (Exception e){
                //Logging.logger.info("Ekran goruntusu alinamadi "+e.getMessage());
            }
        }
        if(newPostAddedSuccessfully)
        {
            //driver.get("https://checkout.hepsiburada.com/sepetim");

            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }
}

package scenarios;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.epamApp.BudgetActivityPage;
import pageObjects.epamApp.EpamLoginPage;
import setup.BaseTest;
import testdata.TestDataProvider;

import java.io.File;
import java.io.IOException;

public class nativeMobileTests extends BaseTest {

    @Test(enabled = true, groups = {"native"}, description = "loggin test after registration new user's account",
            dataProviderClass = TestDataProvider.class, dataProvider = "dataForNativeTest")
    public void registerTest(String userEmail, String userLogin, String userPassword) {

        EpamLoginPage epamPO = new EpamLoginPage(appiumDriver);
        epamPO.clickRegisterBtn()
                .enterEmailDuringRegistration(userEmail)
                .enterUserDuringRegistration(userLogin)
                .enterPasswordDuringRegistration(userPassword)
                .confirmPasswordDuringRegistration(userPassword)
                .clickNewAccountBtn()
                .enterLogin(userLogin)
                .enterPassword(userPassword)
                .clickSignInBtn();
        Assert.assertTrue(new BudgetActivityPage(appiumDriver).checkNewExpenseBtnVisibility(),
                "page BudgetActivity wasn't opened");
        System.out.println("Registration new account & then logging test done:");
    }

    @Test(enabled = false, groups = {"native"}, description = "Simple test just click on the Sign In button")
    public void simpleNativeTest() throws IOException, InterruptedException {
        EpamLoginPage epamPO = new EpamLoginPage(appiumDriver);
        epamPO.clickSignInBtn();
        makeScreenshot();
//        new TemplateMatching();
    }

    public void makeScreenshot() throws InterruptedException, IOException {
        String path = ".//src/main/java/utils/image";
        for (File myFile : new File(path).listFiles()) {
            if (myFile.isFile()) myFile.delete();
        }
        Thread.sleep(5000);
        TakesScreenshot sc = (TakesScreenshot) appiumDriver;
        File screensFile = sc.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screensFile, new File(".//src/main/java/utils/image/signInScreenshot.png"));
    }
}

package scenarios;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.NativePageObject;
import setup.BaseTest;

import java.io.File;
import java.io.IOException;

public class nativeMobileTests extends BaseTest {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    private WebElement registrationEmail;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    private WebElement registrationUsername;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    private WebElement registrationPassword;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    private WebElement confirmPassword;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    private WebElement newAccountBtn;

    @Test(enabled = false, groups = {"native"}, description = "loggin test after registration new user's account")
    public void registerTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        final String userLogin = "a.@epam.com", userPassword = "12345678";
        //       getPo().getWelement("login").sendKeys("a.@epam.com");
        //       getPo().getWelement("password").sendKeys("a123");
        //       getPo().getWelement("registerBnt").click();
//        System.out.println("Simplest Android native test done");

        NativePageObject epamPO = new NativePageObject(getDriver());

        epamPO.clickRegisterBtn()
                .enterEmailDuringRegistration(userLogin)
                .enterUserDuringRegistration(userLogin)
                .enterPasswordDuringRegistration(userPassword)
                .confirmPasswordDuringRegistration(userPassword)
                .clickNewAccountBtn()
                .enterLogin(userLogin)
                .enterPassword(userPassword)
                .clickSignInBtn();
        Assert.assertTrue(epamPO.checkNewExpenseBtnVisibility(), "page BudgetActivity wasn't opened");
        System.out.println("Registration new account & then logging in test done:");
        System.out.println("page BudgetActivity has appeared");
    }

    @Test(groups = {"native"}, description = "Simple test just click on the Sign In button")
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException, IOException, InterruptedException {
//        getPo().getWelement("signInBtn").click();
        NativePageObject epamPO = new NativePageObject(getDriver());
        epamPO.clickSignInBtn();
        makeScreenshot();

        System.out.println("Simplest Android native test done");


    }

    public void makeScreenshot() throws InterruptedException, IOException {
        TakesScreenshot sc = (TakesScreenshot) getDriver();
        Thread.sleep(5000);
        File screensFile = sc.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screensFile, new File("C:\\Users\\ad\\WebDrivers\\screenShotHW2.png"));


    }
}

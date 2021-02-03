package scenarios;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.NativePageObject;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    //  @Test(groups = {"native"}, description = "Simple test just click on the Sign In button")
    //  public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
    //      getPo().getWelement("signInBtn").click();
    //      System.out.println("Simplest Android native test done");
    //  }

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

    @Test(groups = {"native"}, description = "loggin test after registration new user's account")
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

}

package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativePageObject {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    private WebElement login;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    private WebElement password;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    private WebElement signInBtn;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    private WebElement registerBtn;

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

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/add_new_expense")
    private MobileElement newExpenseBtn;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/expenses_list")
    private MobileElement expenseList;

    public NativePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public NativePageObject enterLogin(String email) {
        login.sendKeys(email);
        return this;
    }

    public NativePageObject enterPassword(String pass) {
        password.sendKeys(pass);
        return this;
    }

    public NativePageObject clickRegisterBtn() {
        registerBtn.click();
        return this;
    }

    public NativePageObject clickSignInBtn() {
        signInBtn.click();
        return this;
    }

    public NativePageObject enterEmailDuringRegistration(String login) {
        registrationEmail.sendKeys(login);
        return this;
    }

    public NativePageObject enterUserDuringRegistration(String login) {
        registrationUsername.sendKeys(login);
        return this;
    }

    public NativePageObject enterPasswordDuringRegistration(String pass) {
        registrationPassword.sendKeys(pass);
        return this;
    }

    public NativePageObject confirmPasswordDuringRegistration(String pass) {
        confirmPassword.sendKeys(pass);
        return this;
    }

    public NativePageObject clickNewAccountBtn() {
        newAccountBtn.click();
        return this;
    }

    public boolean checkNewExpenseBtnVisibility() {
        return newExpenseBtn.isDisplayed();
    }


}

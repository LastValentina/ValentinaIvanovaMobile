package pageObjects.epamApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pageObjects.NativePageObject;

public class EpamLoginPage extends NativePageObject {
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

    public EpamLoginPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public EpamLoginPage enterLogin(String email) {
        login.sendKeys(email);
        return this;
    }

    public EpamLoginPage enterPassword(String pass) {
        password.sendKeys(pass);
        return this;
    }

    public EpamLoginPage clickRegisterBtn() {
        registerBtn.click();
        return this;
    }

    public void clickSignInBtn() {
        signInBtn.click();
    }

    public EpamLoginPage enterEmailDuringRegistration(String login) {
        registrationEmail.sendKeys(login);
        return this;
    }

    public EpamLoginPage enterUserDuringRegistration(String login) {
        registrationUsername.sendKeys(login);
        return this;
    }

    public EpamLoginPage enterPasswordDuringRegistration(String pass) {
        registrationPassword.sendKeys(pass);
        return this;
    }

    public EpamLoginPage confirmPasswordDuringRegistration(String pass) {
        confirmPassword.sendKeys(pass);
        return this;
    }

    public EpamLoginPage clickNewAccountBtn() {
        newAccountBtn.click();
        return this;
    }

}

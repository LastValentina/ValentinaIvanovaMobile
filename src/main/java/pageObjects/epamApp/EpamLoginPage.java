package pageObjects.epamApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pageObjects.NativePageObject;

public class EpamLoginPage extends NativePageObject {
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    private WebElement login;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    private WebElement password;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Sign In']")
    private WebElement signInBtn;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Register new account']")
    private WebElement registerBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    private WebElement registrationEmail;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='TimApple']")
    private WebElement registrationUsername;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    private WebElement registrationPassword;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Repeat please']")
    private WebElement confirmPassword;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Register new account']")
    private WebElement newAccountBtn;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label='I read agreaments and agree wit it']")
    private MobileElement agreeBtn;

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

    public EpamLoginPage clickAgreeBtn(String platformName) {
        if (platformName.contains("iOS")) {
            agreeBtn.click();
        }
        return this;
    }
}

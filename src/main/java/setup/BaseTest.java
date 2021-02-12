package setup;

import driver.Driver;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageObjects.PageObject;

public class BaseTest {
    public static AppiumDriver appiumDriver;
    IPageObject po;

    public IPageObject getPo() {
        return po;
    }

    @Parameters({"platformName", "appType", "deviceName", "udid", "browserName", "app", "appPackage", "appActivity", "bundleId"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String platformName, String appType,
                      @Optional("") String deviceName,
                      @Optional("") String udid,
                      @Optional("") String browserName,
                      @Optional("") String app,
                      @Optional("") String appPackage,
                      @Optional("") String appActivity,
                      @Optional("") String bundleId) throws Exception {
        System.out.println("Before: app type - " + appType);
        appiumDriver = new Driver(platformName, deviceName, udid, browserName, app, appPackage, appActivity, bundleId).getDriver();
        setPageObject(appType, appiumDriver);
    }

    @Parameters("deviceName")
    @AfterSuite(alwaysRun = true)
    public void tearDown(String deviceName) {
        System.out.println("After");
        appiumDriver.closeApp();
    }

    private void setPageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        po = new PageObject(appType, appiumDriver);
    }

}

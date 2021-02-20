package setup;

import driver.Driver;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageObjects.PageObject;
import utils.cloud.ApiRequest;

public class BaseTest {
    public static AppiumDriver appiumDriver;
    IPageObject po;
    ApiRequest apiRequest = new ApiRequest();

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

        apiRequest.takeDevice(udid);
    }

    @Parameters("udid")
    @AfterSuite(alwaysRun = true)
    public void tearDown(String udid) {
        System.out.println("After Suite");
        appiumDriver.closeApp();
        apiRequest.stopUseDevice(udid);
    }

    private void setPageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        po = new PageObject(appType, appiumDriver);
    }

}

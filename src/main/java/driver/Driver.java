package driver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import setup.IDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver implements IDriver {
    private AppiumDriver appiumDriver;

    @Override
    public AppiumDriver getDriver() {
        return appiumDriver;
    }

    public Driver(String platformName, String deviceName, String browserName, String app) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("deviceName", deviceName);
        if (app.endsWith(".apk")) capabilities.setCapability("app", (new File(app)).getAbsolutePath());
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck", "true");
        try {
            appiumDriver = new AppiumDriver(new URL(System.getProperty("ts.appium")), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        appiumDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }
}
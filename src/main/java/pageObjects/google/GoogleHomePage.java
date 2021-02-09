package pageObjects.google;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.WebPageObject;

import java.util.List;

public class GoogleHomePage extends WebPageObject {
    private final static String HOME_URL = "https://www.google.com";
    private WebDriver driver;
    @FindBy(xpath = "//*[@id='tsf']//button[@class='Tg7LZd search_button_suggest']")
    private WebElement searchBtn;
    @FindBy(xpath = "//*[@id='tsf']//input[@class='gLFyf']")
    private WebElement searchReq;
    @FindBy(xpath = "//*[@id='rso']//div/a")
    private List<WebElement> searchResults;

    public GoogleHomePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        this.driver = appiumDriver;
    }

    public GoogleHomePage enterSearchRequest(String text) {
        searchReq.sendKeys(text);
        searchReq.sendKeys(Keys.ENTER);
        return this;
    }

    public GoogleHomePage clickSearchBtn() {
        searchBtn.click();
        return this;
    }

    public int getSearchResultListSize() {
        return searchResults.size();
    }

    public GoogleHomePage openPage() {
        driver.get(HOME_URL);
        return this;
    }

}

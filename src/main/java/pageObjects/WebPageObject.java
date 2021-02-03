package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebPageObject {

    @FindBy(xpath = "//*[@id='tsf']//button[@class='Tg7LZd search_button_suggest']")
    //*[@id='tsf']/div[2]/div[1]/div[1]/button[2]
    private WebElement searchBtn;
    @FindBy(xpath = "//*[@id='tsf']//input[@class='gLFyf']")     //*[@id='tsf']/div[2]/div[1]/div[1]/div/div[1]/input
    private WebElement searchReq;
    @FindBy(xpath = "//*[@id='rso']//div/a")   //*[@id="rso"]/div[1]/div/div/div[1]/div/a
    private List<WebElement> searchResults;


    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }

    public WebPageObject enterSearchRequest(String text) {
        searchReq.sendKeys(text);
        searchReq.sendKeys(Keys.ENTER);
        return this;
    }

    public WebPageObject clickSearchBtn() {
        searchBtn.click();
        return this;
    }

    public int checkSearchResultListSize() {
        return searchResults.size();
    }

    public WebPageObject checkFistReferenceOfSearchResultList() {
        searchResults.get(0).click();
        return this;
    }

}

package scenarios;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.WebPageObject;
import setup.BaseTest;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Make sure that we've got search results by 'EPAM' via Google")
    public void simpleWebTest() throws InterruptedException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        getDriver().get("https://www.google.com"); // open google homepage

        // Make sure that page has been loaded completely
        //      new WebDriverWait(getDriver(), 10).until(
        //              wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        //      );

        // Check Google homepage title
        assert ((WebDriver) getDriver()).getTitle().equals("Google") : "This is not google homepage";
        System.out.println("site title: " + getDriver().getTitle());


        //      getPo().getWelement("input").sendKeys("EPAM");

        System.out.println("Site is opened");

        WebPageObject webPO = new WebPageObject(getDriver());
        webPO.clickSearchBtn()
                .enterSearchRequest("EPAM");
        System.out.println("search is done");
        System.out.println("search by EPAM is done");
        System.out.println(webPO.checkSearchResultListSize());
        Assert.assertTrue(webPO.checkSearchResultListSize() > 0, "There is zero- result list");
        webPO.checkFistReferenceOfSearchResultList();
        // Log that test finished
        System.out.println("Site is opened");
    }

}

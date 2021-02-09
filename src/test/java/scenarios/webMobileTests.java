package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.google.GoogleHomePage;
import setup.BaseTest;
import testdata.TestDataProvider;

import static java.lang.String.format;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Make sure that we've got search results by {expression} via Google",
            dataProviderClass = TestDataProvider.class, dataProvider = "dataForWebTest")
    public void searchingWebTest(String expression) {
        GoogleHomePage googlePO = new GoogleHomePage(appiumDriver);
        googlePO.openPage()
                .clickSearchBtn()
                .enterSearchRequest(expression);
        Assert.assertTrue(googlePO.getSearchResultListSize() > 0, "Result list is empty");
        System.out.println(format("search by %s is done", expression));             // Log that test finished
    }

}

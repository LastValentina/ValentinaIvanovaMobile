package testdata;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider
    public Object[][] dataForWebTest() {
        return new Object[][]{
                {"EPAM"},
        };
    }

    @DataProvider
    public Object[][] dataForNativeTest() {
        return new Object[][]{
                {"a.@epam.com", "a.@epam.com", "12345678"},
        };
    }
}


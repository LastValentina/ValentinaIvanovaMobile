package pageObjects.epamApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pageObjects.NativePageObject;

public class BudgetActivityPage extends NativePageObject {
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/add_new_expense")
    private MobileElement newExpenseBtn;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/expenses_list")
    private MobileElement expenseList;

    public BudgetActivityPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean checkNewExpenseBtnVisibility() {
        return newExpenseBtn.isDisplayed();
    }
}

package Framework.pageTests;

import Framework.pageObjects.HomePageObject;
import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static utils.extentReport.ExtentTestManager.startTest;

import java.lang.reflect.Method;

public class HomeTest extends BaseTest {

    @BeforeMethod
    public void openHomePage(Method method){
        startTest(method.getName(),"Main Tests");
        homePageObject
                .openWebsite(properties.getProperty("baseUrl"));
    }

    @Test(priority = 0, description = "Check whether all articles have authors or not")
    public void checkAuthorNames(){
        homePageObject
                .checkAuthorsExist()
                .assertCheckAuthorsExist();
    }


}

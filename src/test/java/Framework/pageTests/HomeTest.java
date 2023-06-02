package Framework.pageTests;

import Framework.pageObjects.HomePageObject;
import Framework.pageObjects.LeverApplicationPage;
import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static utils.extentReport.ExtentTestManager.startTest;

import java.lang.reflect.Method;

public class HomeTest extends BaseTest {
boolean siteControl = true;
    @BeforeMethod
    public void openHomePage(Method method){
        if(siteControl) {
            startTest(method.getName(),"Main Tests");
            homePageObject
                    .openWebsite(properties.getProperty("baseUrl"));
            siteControl = false;
        }

    }

    @Test(priority = 0, description = "Check home page")
    public void checkHomePage(){
        homePageObject.checkHomePage();

    }

    @Test(priority = 1, description = "Check career page elements")
    public void checkCareerPageElements(){
        homePageObject.clickMoreButtonGoCareerPage();
        careerPageObjects.checkLocationTeamsAndLife();

    }

    @Test(priority = 2, description = "Click to see all teams and see all qa jobs for each job filter page and select Istanbul as location with QA Department")
    public void QAJobFilter(){
        careerPageObjects.clickToSeeAllTeams();
        careerPageObjects.clickToQATeam();
        qaJobPage.clickToSeeAllQAJobs();
        jobFilterPAge.checkAndSelectIstanbulFromFilter();
        jobFilterPAge.checkAndSelectQADepartmentFromFilter();
    }

    @Test(priority = 3, description = "Check all filtered jobs have QA Title,Istanbul Location, QA Department and Apply Button")
    public void checkFilteredJobs(){
        jobFilterPAge.checkThatAllJobsHaveSameFilteredSettings();
    }

    @Test(priority = 4,description = "Click to apply button and check if it directed to lever page")
    public void checkLeverPage(){
        jobFilterPAge.clickToApplyButton();
        leverApplicationPage.checkThatThisPageLeverPage();
    }

}

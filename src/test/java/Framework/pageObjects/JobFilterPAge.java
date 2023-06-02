package Framework.pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class JobFilterPAge extends BasePage {
    public JobFilterPAge(WebDriver driver){
        super(driver);
    }

    By locationFilterBar = By.xpath("//span[@id='select2-filter-by-location-container']");
    By istanbulLocation = By.xpath("//li[contains(text(),\"Istanbul, Turkey\")]");
    By departmentFilterBar = By.xpath("//span[@id='select2-filter-by-department-container']");
    By qaDepartment = By.xpath("//li[contains(text(),'Quality Assurance')]");

    By allFilteredJobs = By.cssSelector("div.position-list-item");
    By filteredJobsQATitle = By.xpath("//div/p[contains(text(),'Quality Assurance')]");
    By allFilteredIstanbulLocations = By.xpath("//div/div[contains(text(),'Istanbul, Turkey')]");
    By allFilteredQADepartmens = By.xpath("//div/span[contains(text(),'Quality Assurance')]");
    By filteredJobsApplyButton = By.xpath("//div/a[contains(text(),'Apply Now')]");
    By FirtsApply = By.linkText("Apply Now");
    By FirstJob = By.xpath("(//div/div[contains(text(),'Istanbul, Turkey')])[1]");


    public JobFilterPAge checkAndSelectIstanbulFromFilter(){
        waitForLoad(5000);
        untilElementIsVisible(locationFilterBar);
        clickToElement(locationFilterBar);
        untilElementIsVisible(istanbulLocation);
        Assert.assertTrue(elementIsPresent(istanbulLocation),"Istanbul location is not appearing in filter list");
        clickToElement(istanbulLocation);
        return this;
    }

    public JobFilterPAge checkAndSelectQADepartmentFromFilter(){
        clickToElement(departmentFilterBar);
        Assert.assertTrue(elementIsPresent(qaDepartment),"QA Department is not appearing in filter list");
        clickToElement(qaDepartment);
        return this;
    }

    public JobFilterPAge checkThatAllJobsHaveSameFilteredSettings(){
        waitForLoad(5000);
        List<WebElement> allJobs = findElementsOfList(allFilteredJobs);
        List<WebElement> allQATitles = findElementsOfList(filteredJobsQATitle);
        List<WebElement> allIstanbulLocations = findElementsOfList(allFilteredIstanbulLocations);
        List<WebElement> allQADepartments = findElementsOfList(allFilteredQADepartmens);
        List<WebElement> allApplyButtons = findElementsOfList(filteredJobsApplyButton);
        untilElementIsVisible(filteredJobsApplyButton);
        if(elementIsPresent(allFilteredJobs)) {
            Assert.assertTrue(allJobs.size() == allQATitles.size(), "There is missing QA titles for jobs");
            Assert.assertTrue(allJobs.size() == allIstanbulLocations.size(), "There is missing Istanbul locations for jobs");
            Assert.assertTrue(allJobs.size() == allQADepartments.size(), "There is missing QA Departments for jobs");
            Assert.assertTrue(allJobs.size() == allApplyButtons.size(), "There is missing Apply Buttons for jobs");
        }
        else{
            Assert.assertTrue(false,"Something went wrong");
        }
        return this;
    }

    public JobFilterPAge clickToApplyButton(){
        untilElementIsVisible(FirstJob);
        scrollToElement(FirstJob);
        HighLightBy(FirstJob);
        waitForLoad(5000);
        clickToHoverElement(FirstJob);
        waitForLoad(3000);
        clickWithJS(FirtsApply);
        waitForLoad(10000);
        return this;
    }
}

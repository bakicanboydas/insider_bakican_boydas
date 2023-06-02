package Framework.pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LeverApplicationPage extends BasePage {
    public LeverApplicationPage(WebDriver driver){
        super(driver);
    }

    By leverPageApplyButton = By.xpath("//a[contains(text(),'Apply for this job')]");


    public LeverApplicationPage checkThatThisPageLeverPage(){
        switchTabForTwoTabs();
        Assert.assertTrue(elementIsPresent(leverPageApplyButton),"This page is not lever page");
        return this;
    }
}

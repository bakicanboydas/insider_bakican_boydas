package Framework.pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QAJobPage extends BasePage {
    public QAJobPage(WebDriver driver){
        super(driver);
    }


    By seeAllQAJobs = By.xpath("//a[contains(text(),'See all QA jobs')]");

    public QAJobPage clickToSeeAllQAJobs(){
        clickToElement(seeAllQAJobs);
        return this;
    }
}

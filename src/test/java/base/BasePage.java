package base;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.extentReport.ExtentTestManager;

import java.time.Duration;
import java.util.List;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void getUrl(String url){
        driver.get(url);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    protected boolean elementIsPresent(By element){
        return driver.findElements(element).size() > 0;
    }

    protected List findElementsOfList(By elementBy){return driver.findElements(elementBy);}

    protected String getInfoMessage(String message){
        ExtentTestManager.getTest().log(Status.INFO,message);
        return message;
    }

    @BeforeClass
    public void beforeClass(){
        getInfoMessage("Tests are starting!");
    }

    @AfterClass
    public void afterClass(){
        getInfoMessage("Tests are ending!");
    }
}

package base;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.extentReport.ExtentTestManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void getUrl(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected boolean elementIsPresent(By element) {
        return driver.findElements(element).size() > 0;
    }

    public void clickToElement(By element) {
        driver.findElement(element).click();
    }

    public void clickElementIfExist(By element) {
        if (elementIsPresent(element)) {
            clickToElement(element);
        }
    }
    public void HighlightElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element," border: 3px solid red;");
    }
    protected WebElement untilElementIsVisible(By elementBy) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
            HighlightElement(element);
            return element;
        } catch (Exception e) {
            return null;
        }
    }
    public void HighLightBy(By elementBy){
        WebElement element = driver.findElement(elementBy);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element," border: 3px solid red;");
    }
    public void clickWithJS(By element){
        WebElement button = driver.findElement(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",button);
    }

    public void switchTabForTwoTabs(){
        ArrayList<String> newTB = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTB.get(0));
        driver.close();
        waitForLoad(5000);
        driver.switchTo().window(newTB.get(1));

    }
    protected void scrollToElement(By elementBy) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(elementBy);
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        waitForLoad(500);
    }

    protected void waitForLoad(int miliseconds){
        try {
            Thread.sleep(miliseconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    protected List findElementsOfList(By elementBy) {
        return driver.findElements(elementBy);
    }

    public void clickToHoverElement(By element){
        WebElement elementt = driver.findElement(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(elementt).build().perform();
    }

    protected String getInfoMessage(String message) {
        ExtentTestManager.getTest().log(Status.INFO, message);
        return message;
    }

}

package base;

import Framework.pageObjects.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;

    public HomePageObject homePageObject;
    public CareerPageObjects careerPageObjects;
    public QAJobPage qaJobPage;
    public JobFilterPAge jobFilterPAge;
    public LeverApplicationPage leverApplicationPage;

    public Properties properties;
    FileInputStream fileInputStream;

    public WebDriver getDriver(){return driver;}
    @Parameters("browserName")
    @BeforeClass(alwaysRun = true)
    public void setup(String browserName) throws Exception{
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }

    }

    @BeforeMethod(alwaysRun = true)
    public void methodSetup() throws IOException{
        getReadPropFile();

        homePageObject = new HomePageObject(driver);
        careerPageObjects = new CareerPageObjects(driver);
        qaJobPage = new QAJobPage(driver);
        jobFilterPAge = new JobFilterPAge(driver);
        leverApplicationPage = new LeverApplicationPage(driver);
    }

    public void getReadPropFile() throws IOException {
        properties = new Properties();
        fileInputStream = new FileInputStream("src/test/resources/config.properties");
        properties.load(fileInputStream);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {driver.quit();}
}

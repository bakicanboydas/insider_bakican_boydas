package base;

import Framework.pageObjects.HomePageObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;

    public HomePageObject homePageObject;

    public Properties properties;
    FileInputStream fileInputStream;

    public WebDriver getDriver(){return driver;}

    @BeforeClass(alwaysRun = true)
    public void setup() throws Exception{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod(alwaysRun = true)
    public void methodSetup() throws IOException{
        getReadPropFile();

        homePageObject = new HomePageObject(driver);
    }

    public void getReadPropFile() throws IOException {
        properties = new Properties();
        fileInputStream = new FileInputStream("src/test/resources/config.properties");
        properties.load(fileInputStream);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {driver.quit();}
}

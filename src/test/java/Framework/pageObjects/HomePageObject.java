package Framework.pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HomePageObject extends BasePage {
    public HomePageObject(WebDriver driver) {
        super(driver);
    }
    By cookieAcceptButton = By.xpath("//a[contains(text(),'Accept All')]");
    By insiderLogo = By.cssSelector("a.navbar-brand>img[src*=\"insider\"]");
    By moreMenu = By.xpath("//span[contains(text(),'More')]");
    By careerMenu = By.xpath("//h5[contains(text(),'Careers')]");


    public HomePageObject checkHomePage() {
        if (elementIsPresent(insiderLogo)) {
            Assert.assertTrue(elementIsPresent(insiderLogo), "Homepage was not opened!");
            getInfoMessage("The homepage was successfully opened as expected.");
        }
        return this;
    }

    public HomePageObject clickMoreButtonGoCareerPage(){
        clickToElement(moreMenu);
        clickToElement(careerMenu);

        return this;
    }

    public HomePageObject openWebsite(String url) {
        getUrl(url);
        if (url.equals(getCurrentUrl())) {
            Assert.assertTrue(url.equals(getCurrentUrl()), "URL is not true!");
            getInfoMessage("The URL is true as expected");
        }

        clickElementIfExist(cookieAcceptButton);

        return this;
    }
}

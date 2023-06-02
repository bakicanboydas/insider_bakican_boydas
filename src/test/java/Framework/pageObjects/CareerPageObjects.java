package Framework.pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CareerPageObjects extends BasePage {
    public CareerPageObjects(WebDriver driver) {
        super(driver);
    }

    By ourLocations = By.xpath("//h3[contains(text(),'Our Locations')]");
    By seeAllTeams = By.xpath("//a[contains(text(),'See all teams')]");
    By lifeAtInsider = By.xpath("//h2[contains(text(),'Life at Insider')]");
    By careerPageQATeam = By.xpath("//h3[contains(text(),'Quality Assurance')]");


    public CareerPageObjects checkLocationTeamsAndLife(){
        Assert.assertTrue(elementIsPresent(ourLocations),"Our Locations element is not visible");
        Assert.assertTrue(elementIsPresent(seeAllTeams),"See All Teams element is not visible");
        Assert.assertTrue(elementIsPresent(lifeAtInsider),"Life At Insider element is not visible");
        return this;
    }

    public CareerPageObjects clickToSeeAllTeams(){
        scrollToElement(seeAllTeams);
        untilElementIsVisible(seeAllTeams);
        clickWithJS(seeAllTeams);
        return this;
    }

    public CareerPageObjects clickToQATeam(){
        clickToSeeAllTeams();
        scrollToElement(careerPageQATeam);
        untilElementIsVisible(careerPageQATeam);
        clickWithJS(careerPageQATeam);
        return this;
    }

}

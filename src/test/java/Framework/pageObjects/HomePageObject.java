package Framework.pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HomePageObject extends BasePage {
    public HomePageObject(WebDriver driver) {super(driver);}

    By allAuthors = By.cssSelector(".river-byline__authors");
    By allArticles = By.cssSelector("article.post-block");
    By websiteLogo = By.cssSelector(".desktop-nav__header .logo");


    List<WebElement> authors;
    List<WebElement> articles;

    public HomePageObject checkAuthorsExist(){
        authors = findElementsOfList(allAuthors);
        articles = findElementsOfList(allArticles);
        return this;
    }

    public HomePageObject assertCheckAuthorsExist(){
        for(WebElement value : authors){
            System.out.println(value.getText());
        }
        System.out.println("the size of authors: "+authors.size());
        for(WebElement value2 : articles){
            System.out.println(value2.getText());
        }
        System.out.println("the size of articles: "+articles.size());
        Assert.assertTrue(authors.size()==articles.size(),"Article number is not equal to author number");
        getInfoMessage("The number of articles and the number of authors are equal as expected.");
        return this;
    }

    public HomePageObject openWebsite(String url){
        getUrl(url);
        if(url.equals(getCurrentUrl())){
            Assert.assertTrue(url.equals(getCurrentUrl()),"URL is not true!");
            getInfoMessage("The URL is true as expected");
        }
        if(elementIsPresent(websiteLogo)){
            Assert.assertTrue(elementIsPresent(websiteLogo),"Homepage was not opened!");
            getInfoMessage("The homepage was successfully opened as expected.");
        }
        return this;
    }
}

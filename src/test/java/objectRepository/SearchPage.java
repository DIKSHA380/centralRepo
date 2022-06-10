package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    WebElement search;

    @FindBy(xpath = "//*[@id='search']/div/input")
    WebElement PressEnter;

    @FindBy(xpath = "//*[@class='s-link']")
    List<WebElement> ListOfQuest;

    @FindBy(xpath = "//*[@id='mainbar']/div[4]/div/div[2]/div/div[1]/button")
    WebElement SortDropdown;

    @FindBy(xpath = "//*[@id='uql-more-popover']/ul/li[4]/a")
    WebElement SortByVotes;



    public void searchBySeleniumTag(String tag){
        search.sendKeys(tag);
        PressEnter.sendKeys(Keys.ENTER);
    }
    public int findNoOfQuestions(){
        List<WebElement> quest= ListOfQuest;
        int noOfQuest = quest.size();
        return noOfQuest;


    }
    public void sortByVoteReceived(){
        SortDropdown.click();
        SortByVotes.click();
    }

}







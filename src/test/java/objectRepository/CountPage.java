package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CountPage {
    WebDriver driver;

    public CountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='s-post-summary--content-title']")
    List<WebElement> questByVotes;

    @FindBy(xpath = "//*[contains(@title,'Score of')]")
    List<WebElement> voteCount;

    @FindBy(xpath = "//*[contains(@id,\"question-summary\" )]/div[1]/div[2]/span[1]")
    List<WebElement> answerCount;

    @FindBy(xpath = "//*[contains(@id,'question-summary')]")
    List<WebElement> otherTagIds;

    public String getAllQuestionsOnPage(int i) {
        return questByVotes.get(i).getText();

    }

    public String getVoteCount(int i) {
        return voteCount.get(i).getText().split(" ")[0];

    }

    public String getAnswerCount(int i) {

        return answerCount.get(i).getText();
    }

    public void getOtherTags(int i) {

        String attribute = otherTagIds.get(i).getAttribute("id");
        List<WebElement> otherTags = driver.findElements(By.xpath("//*[@id='" + attribute + "']/div[2]/div[2]/div[1]/a"));
        int count = otherTags.size();

        for (int j = 0; j < count; j++) {

            if (otherTags.get(j).getText().equals("selenium")) {
                continue;
            } else {
                System.out.println(otherTags.get(j).getText());
            }
        }
    }
}


package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AnswerPage {
    WebDriver driver;

    public AnswerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//*[@class='s-link']")
    List<WebElement> question;

    @FindBy(xpath="//*[contains(@id,'answer')]/div/div[1]/div/div[2]")
    WebElement answerVote;

    public void getAnswerVotesPerQuestion(int i)
    {
        List<WebElement> quest1=question;
        quest1.get(i).click();
        System.out.println(answerVote.getText());
        driver.navigate().back();
    }
}

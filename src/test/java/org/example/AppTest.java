package org.example;

import static org.junit.Assert.assertTrue;

import objectRepository.AnswerPage;
import objectRepository.CountPage;
import objectRepository.LoginPage;
import objectRepository.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import utility.property;

/**
 * Unit test for simple App.
 */
public class AppTest {
    WebDriver driver;
    property config=new property();
    @Test
    public void login() {

        driver = BaseTest.BeforeRun(driver, config.getBrowser(), config.getUrl());
        LoginPage obj = new LoginPage(driver);
        obj.loginToStackOverflow(config.getUsername(), config.getPassword());
    }

    @Test(dependsOnMethods = "login", description = "Search for questions related to selenium tag")
    public void searchTag() throws InterruptedException {
        SearchPage sbt = new SearchPage(driver);
        Thread.sleep(3000);
        sbt.searchBySeleniumTag(config.getTag());
    }

    @Test(dependsOnMethods = "searchTag", description = "Verify that there are only 15 questions on the page and sort by votes received")
    public void noOfQuestions() {
        SearchPage noq = new SearchPage(driver);
        Assert.assertEquals(noq.findNoOfQuestions(), 15, "No. of questions on page is not 15");
        System.out.println("---Verification:  No. of questions on the page is 15 ---");
        noq.sortByVoteReceived();

    }

    @Test(dependsOnMethods = "noOfQuestions", description = "count no.of votes, answers and list of other tags for each question on page")
    public void VoteAnswersOtherTags() {
        CountPage cp = new CountPage(driver);
        for (int i = 0; i < 15; i++) {
            System.out.println("Question No " + (i + 1) + "- " + cp.getAllQuestionsOnPage(i));
            System.out.println("Vote Count- " + cp.getVoteCount(i));
            System.out.println("Answer Count- " + cp.getAnswerCount(i));
            System.out.println("List of Other Tags------------");
            cp.getOtherTags(i);
            System.out.println("***********************************************************************************");
        }
    }

    @Test(dependsOnMethods = "VoteAnswersOtherTags", description = "extract out the votes received by accepted answer")
    public void acceptedAnswerVotes() {
        AnswerPage ap = new AnswerPage(driver);
        for (int i = 0; i < 15; i++) {
            System.out.println("votes received by accepted answer on question- " + (i + 1));
            ap.getAnswerVotesPerQuestion(i);
            System.out.println("_______________________________________________________________");
        }


    }
    @AfterSuite
    public void closeBrowser(){
        BaseTest.quitBrowser(driver);
    }

}


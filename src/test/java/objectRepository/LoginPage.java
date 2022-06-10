package objectRepository;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/header/div/ol[2]/li[3]/a")
    WebElement LoginButton;

    @FindBy(id = "email")
    WebElement userEmail;

    @FindBy(id = "password")
    WebElement userPassword;

    @FindBy(id = "submit-button")
    WebElement submitButton;

    public void loginToStackOverflow(String username, String pass){
        LoginButton.click();
        userEmail.sendKeys(username);
        userPassword.sendKeys(pass);
        submitButton.click();
    }
}
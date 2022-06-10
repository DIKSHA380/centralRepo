package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;


public class BaseTest {

    public static WebDriver BeforeRun(WebDriver driver,String browserName,String appUrl){

        if(browserName.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\dsahay\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get(appUrl);
        }
        else{
            System.out.println("Sorry! Only Chrome browser is supported");
        }
        return driver;
    }
    public static void quitBrowser(WebDriver driver){

        driver.quit();
    }
}

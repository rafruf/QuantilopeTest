package com.quantilope;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {
    static WebDriver wd;
    int i;
    String Str;
    String  Survey_URL = "https://survey.quantilope.com/SfidqfGjdrvMzwzWK/8B9D4YJjjEkJZ9EJ8/9xednGW4bJAGd7sv2";
    String Dashboard_URL = "https://app.quantilope.com/share/gbhGTcBXLWQmiiZXT?type=dashboard";


    @BeforeTest
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.get(Survey_URL);
    }



    public void pause(int time) throws InterruptedException {
        Thread.sleep(time);
    }

    public void NextPage(){
        click(By.cssSelector("[id='nextPage']"));
    }

    public boolean VerifySurveyComplete(){
        boolean eleSelected;
        eleSelected = wd.findElement(By.xpath("//p[contains(text(),'Survey Complete')]")).isDisplayed();
        return eleSelected;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String num) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(num);

    }

    public int RandNum(int max){
        i = (int) Math.floor(Math.random() * max) + 1;
        return i;
    }

    public String ParseStr(int max){
        max = RandNum(max);
        Str = String.valueOf(max);
        return Str;
    }

    public boolean VerifyGraph(){
        //WebElement N_Total = wd.findElement(By.xpath("//div[@class='react-grid-layout']/div[3]/div/div/div/div[2]/div//*[@class='highcharts-root']/*[@class='highcharts-credits']"));
        boolean graph;
        graph = wd.findElement(By.xpath("//div[@class='react-grid-layout']/div[3]/div/div/div/div[2]/div//*[@class='highcharts-root']")).isDisplayed();
        return graph;
    }

    @AfterSuite
    public void tearDown(){
        wd.quit();
    }
}

package com.quantilope;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {
    static WebDriver wd;
    int i;
    String Str;


    @BeforeTest
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.get("https://survey.quantilope.com/SfidqfGjdrvMzwzWK/8B9D4YJjjEkJZ9EJ8/9xednGW4bJAGd7sv2");
    }

    public void startSurvey() {
        wd.get("https://survey.quantilope.com/SfidqfGjdrvMzwzWK/8B9D4YJjjEkJZ9EJ8/9xednGW4bJAGd7sv2");
        click(By.cssSelector("[id='startSurvey']"));
        //comment


    }

    public void FirstQuestion()  {
        click(By.xpath("//div[@class='matrixBody']/div["+RandNum(3)+"]/div/div[1]/div"));
        NextPage();
    }

    public void SecondQuestion()  {
        type(By.xpath("//input[@id='P4fXcL2ThPnuv8Pem']"), ParseStr(100));
        NextPage();
    }

    public void ThirdQuestion() {
        click(By.xpath("//div[@class='matrixBody']/div/div["+RandNum(5)+"]/div/label"));
        NextPage();
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
        Str =String.valueOf(max);
        return Str;
    }

    @AfterSuite
    public void tearDown(){
        wd.quit();
    }
}

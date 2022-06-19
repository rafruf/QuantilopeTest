package com.quantilope;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

class TestExecution extends TestBase{
    int j = 0;
    public void SurveyExe(int num) throws InterruptedException {

        for(int i=0; i<num; ++i) {
            startSurvey();
            FirstQuestion();
            SecondQuestion();
            ThirdQuestion();
            Assert.assertTrue(VerifySurveyComplete());
            pause(100);

            j++;
        }
        System.out.println("Test num:=" + j); // for private using
        tearDown();
    }


    public void startSurvey() {
        wd.get(Survey_URL);
        click(By.cssSelector("[id='startSurvey']"));
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

}

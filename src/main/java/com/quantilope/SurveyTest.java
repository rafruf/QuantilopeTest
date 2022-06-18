package com.quantilope;

import org.testng.annotations.Test;

public class SurveyTest extends TestBase{
    @Test
    public void Login() throws InterruptedException {
        int j = 0;
        for(int i = 0; i<10; ++i) {
            startSurvey();
            FirstQuestion();
            SecondQuestion();
            ThirdQuestion();
            pause(100);

            j++;
        }
        System.out.println(j);

        tearDown();
    }



}

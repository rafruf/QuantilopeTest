package com.quantilope;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SurveyTest extends TestBase{
    @Test
    public void CycleTestExe() throws InterruptedException {
        int testNum = 10; // Enter here num of test exe
        TestExecution t = new TestExecution();
        t.SurveyExe(testNum);

    }

    @Test
    public void GraphValidation(){
        Assert.assertTrue(VerifyGraph());
    }




}

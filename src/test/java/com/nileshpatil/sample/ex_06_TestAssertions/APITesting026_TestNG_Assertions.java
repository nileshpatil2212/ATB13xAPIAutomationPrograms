package com.nileshpatil.sample.ex_06_TestAssertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting026_TestNG_Assertions {

//    @Test
//    public void test_HardAssertExample(){
//        System.out.println("Start of the Program");
//        Assert.assertEquals("nilesh" ,"Nilesh");
//        System.out.println("close of the program");
//
//    }

    @Test
    public void test_SoftAssertExample(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("nilesh" ,"Nilesh");
        System.out.println("close of the program");
        softAssert.assertAll();

    }

}

package com.nileshpatil.sample.ex_05_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting018_TestNG_DependsOnMethod {

    @Test
    public void ServerStartedOk(){
        System.out.println("I Will Run First");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "ServerStartedOk")
    public void test1(){
        System.out.println("method1");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "ServerStartedOk")
    public void test2(){
        System.out.println("method2");
        Assert.assertTrue(true);
    }

}

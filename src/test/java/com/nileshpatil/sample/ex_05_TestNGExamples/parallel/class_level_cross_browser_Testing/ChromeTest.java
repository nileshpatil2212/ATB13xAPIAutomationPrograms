package com.nileshpatil.sample.ex_05_TestNGExamples.parallel.class_level_cross_browser_Testing;

import org.testng.annotations.Test;

public class ChromeTest {

    @Test
    public void test_Chrome1(){
        System.out.println("Chrome ");
        System.out.println(Thread.currentThread().getId());
    }

    @Test
    public void test_Chrome2(){
        System.out.println("Chrome ");
        System.out.println(Thread.currentThread().getId());
    }
}

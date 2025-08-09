package com.nileshpatil.sample.ex_05_TestNGExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting019_TestNG_Parameter {

    @Parameters("browser")
    @Test
    public void demo1(String value){
        System.out.println("Hi I am demo");
        System.out.println("you are running this param");

        if (value.equalsIgnoreCase("firefox")){
            System.out.println("Start the Firefox");
        }

        if (value.equalsIgnoreCase("chrome")){
            System.out.println("Start the Chrome");
        }
        if (value.equalsIgnoreCase("safari")){
            System.out.println("we cant run on safari");
        }
    }
}

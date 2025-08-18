package com.nileshpatil.sample.Class_exersice.restfulbooker.Base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    @BeforeTest
    public void setup(){
        RestAssured.baseURI="https://restful-booker.herokuapp.com";
    }
}

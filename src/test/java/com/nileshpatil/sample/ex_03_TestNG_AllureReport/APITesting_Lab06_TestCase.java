package com.nileshpatil.sample.ex_03_TestNG_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting_Lab06_TestCase {
    String pincode;


    @Test
    // Valid Pincode : 110001
    public void test_tc1_pincode_valid(){
        pincode = "110048";

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("/ping")
                .when().log().all().get()
                .then().log().all().statusCode(201);

    }

    @Test
    // #,$,% and @ -- any special character
    public void test_tc2_pincode_invalid(){
        pincode = "@";

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("/ping")
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }

    @Test
    // '' = blank pincode
    public void test_tc3_pincode_invalid(){
        pincode = " ";

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("/ping")
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }
}

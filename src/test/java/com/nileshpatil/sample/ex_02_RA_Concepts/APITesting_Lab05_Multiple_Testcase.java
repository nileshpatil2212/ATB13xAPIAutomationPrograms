package com.nileshpatil.sample.ex_02_RA_Concepts;

import io.restassured.RestAssured;

public class APITesting_Lab05_Multiple_Testcase {
    public static void main(String[] args) {

        String pincode = "110048";

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("/ping")
                .when().log().all().get()
                .then().log().all().statusCode(200);

        pincode = "#";
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("/ping")
                .when().log().all().get()
                .then().log().all().statusCode(200);

        pincode = "";
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("/ping")
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }
}

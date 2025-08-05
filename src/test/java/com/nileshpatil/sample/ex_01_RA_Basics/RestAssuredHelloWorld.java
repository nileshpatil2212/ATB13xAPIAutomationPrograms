package com.nileshpatil.sample.ex_01_RA_Basics;

import io.restassured.RestAssured;

public class RestAssuredHelloWorld {

    public static void main(String[] args) {


        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("/ping")
                .when()
                .log().all().get().
                then()
                .log().all().statusCode(201);
    }
}

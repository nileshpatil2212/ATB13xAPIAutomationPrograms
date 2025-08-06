package com.nileshpatil.sample.ex_04_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting008_GET_BDDStyle {

    @Test
    public void test_GET_Response(){
        String pincode = "560048";
        RestAssured
                .given()
                .given().baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .log()
                .all()
                .get()
                .then()
                .log().all()
                .statusCode(200);
    }



}




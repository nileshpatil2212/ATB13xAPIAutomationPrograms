package com.nileshpatil.sample.ex_04_RestAssured_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting012_PUT_NonBDDStyle {

    // token , bookingID - A
    RequestSpecification r; // pre request - given part
    Response response; // making the request - when
    ValidatableResponse vr;  // post request - then


    @Test
    public void test_PUT_Non_BDD(){
        String bookingid = "22";
        String token = "ca3d14cd379e3fe";
        String payload = "{\n" +
                "    \"firstname\" : \"Neel\",\n" +
                "    \"lastname\" : \"Patil\",\n" +
                "    \"totalprice\" : 15000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2025-09-20\",\n" +
                "        \"checkout\" : \"2025-09-24\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token" ,token);
        r.body(payload).log().all();

        response = r.when().log().all().put();

        vr = response.then().log().all();
        vr.statusCode(200);

    }
}

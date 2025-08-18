package com.nileshpatil.sample.ex_06_TestAssertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class APITesting027_RestAssured_TestNG_AssertJ_Assertions {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingID;

    @Test
    public void test_POST() {

        // payload
        // given - setting up the body, url, base path, uri
        // when  - making the req
        // then - extraction

        String request_payload = " {\n" +
                "        \"firstname\": \"nilesh\",\n" +
                "        \"lastname\": \"Patil\",\n" +
                "        \"totalprice\": 10000,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2025-08-10\",\n" +
                "            \"checkout\": \"2025-08-17\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Breakfast\"\n" +
                "    }";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");

        // header information
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(request_payload).log().all();

        response = requestSpecification.when().log().all().post();

        // Get Validate response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Rest Assured -> import org.hamcrest.Matchers; %4-%5
        // Matchers.equalto()

        validatableResponse.body("bookingid" , Matchers.notNullValue());
        validatableResponse.body("booking.firstname",Matchers.equalTo("nilesh"));
        validatableResponse.body("booking.lastname",Matchers.equalTo("Patil"));
        validatableResponse.body("booking.depositpaid",Matchers.equalTo(true));

        // Extraction
        // Concept #1 - Normal( TestNG or Assertj) IS IMP

        bookingID = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");

        // Concept #2 - (Jsonpath class) Another mechanism to extract the Keys, value by JSON Path
        JsonPath jp = new JsonPath(response.asString());
        String bookingID1 = jp.getString("bookingid");

        assertThat(jp.getInt("bookingid")).isEqualTo(4907);
        assertThat(jp.getString("booking.firstname")).isEqualTo("pramod");
        assertThat(jp.getString("booking.lastname")).isEqualTo("Dutta");
        assertThat(jp.getInt("booking.totalprice")).isEqualTo(3000);
        assertThat(jp.getBoolean("booking.depositpaid")).isTrue();


        // TestNG - Extract the details of the firstname, bookingId, lastname from Response.
        // TestNG Assertions - 75%
        // SoftAssert vs HardAssert (90%)
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.

        Assert.assertEquals(firstname,"nilesh");
        Assert.assertEquals(lastname,"Patil");
        Assert.assertNotNull(bookingID);

        if (!firstname.contains("nilesh")){
            Assert.fail("Fail kar diya Test");
        }


        assertThat(bookingID).isNotNull().isNotZero().isPositive();
        assertThat(firstname).isNotBlank().isNotEmpty().isNotNull().isEqualTo("nilesh");
        assertThat(lastname).isNotBlank().isNotEmpty().isNotNull().isEqualTo("Patil");


    }
}

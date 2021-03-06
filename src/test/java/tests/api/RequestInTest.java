package tests.api;

import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Feature("Setting API test")
public class RequestInTest {

    @Test
    public void simpleStepByStepApiTest() {

        // Setup RestAssured
        RestAssured.baseURI = "http://restful-booker.herokuapp.com";

        // Setup endpoint
        String endpoint = "/booking";

        // Setup request Object
        RequestSpecification httpRequest = given();

        // Setup Response Object
        Response response = httpRequest.request(Method.GET, endpoint);

        // Get Response Status
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);

        // Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println("Response: " + responseBody);
    }

    @Test
    public void simpleShortApiTest() {
        // Setup RestAssured
        RestAssured.baseURI = "http://restful-booker.herokuapp.com";

        // Setup endpoint
        String endpoint = "/booking";  // настройка endpoint

        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }
}


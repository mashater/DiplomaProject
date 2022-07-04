package tests.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RequestInTest {

    @Test
    public void simpleStepByStepApiTest() {

        // Setup RestAssured
        RestAssured.baseURI = "http://restful-booker.herokuapp.com";

        // Setup endpoint
        String endpoint = "/booking";  // настройка endpoint

        // Setup request Object
        RequestSpecification httpRequest = given();  // как в матем.задаче ДАНО

        // Setup Response Object
        Response response = httpRequest.request(Method.GET, endpoint);   //запрашиваем структура When

        // Get Response Status
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);    // проверяем статус

        // Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println("Response: " + responseBody);     // получение тела и вывод его на экран
    }

    @Test
    public void simpleShortApiTest() {
        // Setup RestAssured
        RestAssured.baseURI = "http://restful-booker.herokuapp.com";   // настройка REST

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


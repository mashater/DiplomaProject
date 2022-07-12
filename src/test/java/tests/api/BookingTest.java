package tests.api;

import baseEntities.BaseAPITest;
import configurations.Endpoints;
import io.restassured.http.ContentType;
import models.Booking;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BookingTest extends BaseAPITest {
    public Booking booking;
    public int bookingid;

    @Test
    public void createBookingTest() {
        booking = Booking.builder()
                .firstname("Jim")
                .lastname("Brown")
                .totalprice(111)
                .depositpaid(true)
                .additionalneeds("Breakfast")
                .build();

        bookingid = given()
                .body(String.format("{\n" +
                        "  \"firstname\" : \"Jim\",\n" +
                        "  \"lastname\" : \"Brown\",\n" +
                        "  \"totalprice\" : 111,\n" +
                        "  \"depositpaid\" : true,\n" +
                        "  \"bookingdates\" : {\n" +
                        "    \"checkin\" : \"2018-01-01\",\n" +
                        "    \"checkout\" : \"2019-01-01\"\n" +
                        "  },\n" +
                        "  \"additionalneeds\" : \"Breakfast\"\n" +
                        "}"))
                .when()
                .post(Endpoints.POST_CREATE_BOOKING)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("bookingid");

        Assert.assertEquals(booking.getFirstname(), "Jim");
        Assert.assertEquals(booking.getLastname(), "Brown");
        Assert.assertEquals(booking.getAdditionalneeds(), "Breakfast");
    }

    @Test(dependsOnMethods = "createBookingTest")
    public void updateBookingTest() {
        given()
                .pathParams("bookingid", bookingid)
                .cookie("token", token)
                .contentType(ContentType.JSON)
                .body(String.format("{\n" +
                        "  \"firstname\" : \"Jim2\",\n" +
                        "  \"lastname\" : \"Brown1\",\n" +
                        "  \"totalprice\" : 111,\n" +
                        "  \"depositpaid\" : true,\n" +
                        "  \"bookingdates\" : {\n" +
                        "    \"checkin\" : \"2018-01-01\",\n" +
                        "    \"checkout\" : \"2019-01-01\"\n" +
                        "  },\n" +
                        "  \"additionalneeds\" : \"Breakfast\"\n" +
                        "}"))
                .when()
                .put(Endpoints.PUT_UPDATE_BOOKING)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test(dependsOnMethods = "updateBookingTest")
    public void deleteBookingTest() {

        given()
                .pathParams("bookingid", bookingid)
                .cookie("token", token)
                .contentType(ContentType.JSON)
                .when()
                .delete(Endpoints.DELETE_BOOKING)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .log().body();
    }
}


package tests.api;

import baseEntities.BaseAPITest;
import configurations.Endpoints;
import models.Booking;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BookingTest extends BaseAPITest {
    public Booking booking;
    public int bookingid;
    public String token;

    @Test
    public void authCreateTokenTest() {
        token = given()
                .body(String.format("{\n" +
                        "    \"username\" : \"admin\",\n" +
                        "    \"password\" : \"password123\"\n" +
                        "}"))
                .when()
                .post(Endpoints.POST_CREATE_TOKEN)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("token");

    }

    @Test(dependsOnMethods = "authCreateTokenTest")
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
                .when()
                .delete(Endpoints.DELETE_BOOKING)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .log().body();
    }
}


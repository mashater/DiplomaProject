package tests.api;

import configuration.Endpoints;
import io.restassured.mapper.ObjectMapperType;
import models.Booking;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BookingTest extends BaseAPITest {
    public Booking booking;
    public int bookingId;

    @Test
    public void createBookingTest() {
        Booking booking = Booking.builder()
                .firstname("Jim")
                .lastname("Brown")
                .totalprice(111)
                .depositpaid(true)
                .additionalneeds("Breakfast")
                .build();

        bookingId = given()
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

        Assert.assertEquals(booking.getLastname(), "Brown");
        Assert.assertEquals(booking.getAdditionalneeds(), "Breakfast");
    }
}

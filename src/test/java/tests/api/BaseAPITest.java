package tests.api;

import helpers.BookingHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Booking;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class BaseAPITest {
    public Booking expectedBooking;
    public BookingHelper bookingHelper;

    @BeforeTest
    public void setupEnv() {
        RestAssured.baseURI = "http://restful-booker.herokuapp.com";

        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);

        expectedBooking =
                Booking.builder()
                        .firstname("Jim")
                        .lastname("Brown")
                        .totalprice(111)
                        .depositpaid(true)
                        .additionalneeds("Breakfast")
                        .build();

        bookingHelper = new BookingHelper();
    }
}

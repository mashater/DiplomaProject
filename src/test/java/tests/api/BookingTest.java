package tests.api;

import configuration.Endpoints;
import models.Booking;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class BookingTest extends BaseAPITest {

    @Test
    public void createBookingTest() {

        Booking newBooking = Booking.builder()
                .firstname("Jim")
                .lastname("Brown")
                .totalprice(111)
                .depositpaid(true)
                .additionalneeds("Breakfast")
                .build();

        given()
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
                .statusCode(HttpStatus.SC_OK);
    }

}

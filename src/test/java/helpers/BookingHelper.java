package helpers;

import configurations.Endpoints;
import io.restassured.response.Response;
import models.Booking;
import org.apache.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BookingHelper {

    public Booking createBooking(Map<String, Object> jsonAsMap) {

        return given()
                .body(jsonAsMap)
                .when()
                .post(Endpoints.POST_CREATE_BOOKING)
                .then()
                .log().status()
                .log().body()
                .extract()
                .as(Booking.class);
    }

    public Booking getBooking() {
        return given()
                .get(Endpoints.GET_BOOKING)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Booking.class);
    }

    public Response getBookingResponse() {
        return given()
                .get(Endpoints.GET_BOOKING_IDS);
    }
}


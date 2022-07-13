package baseEntities;

import configurations.Endpoints;
import helpers.BookingHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Booking;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class BaseAPITest {

    public Booking expectedBooking;
    public BookingHelper bookingHelper;
    public Booking updatedBooking;
    public String token;

    @BeforeTest
    public void setupEnv() {
        RestAssured.baseURI = "http://restful-booker.herokuapp.com";

        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);

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

        expectedBooking = Booking.builder()
                .firstname("Jim")
                .lastname("Brown")
                .totalprice(111)
                .depositpaid(true)
                .additionalneeds("Breakfast")
                .build();

        updatedBooking = Booking.builder()
                .firstname("James")
                .lastname("Brown")
                .totalprice(111)
                .depositpaid(true)
                .additionalneeds("Breakfast")
                .build();

        bookingHelper = new BookingHelper();
    }
}

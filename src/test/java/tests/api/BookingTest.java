package tests.api;

import baseEntities.BaseAPITest;
import configurations.Endpoints;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BookingTest extends BaseAPITest {
    public int bookingid;

    @Test
    public void createBookingTest() {

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

        Assert.assertEquals(expectedBooking.getFirstname(), "Jim");
        Assert.assertEquals(expectedBooking.getLastname(), "Brown");
        Assert.assertEquals(expectedBooking.getAdditionalneeds(), "Breakfast");
    }

    @Test(dependsOnMethods = "createBookingTest")
    public void updateBookingTest() {
        given()
                .pathParams("bookingid", bookingid)
                .cookie("token", token)
                .contentType(ContentType.JSON)
                .body(String.format("{\n" +
                        "  \"firstname\" : \"James\",\n" +
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
                .put(Endpoints.PUT_UPDATE_BOOKING)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();

        Assert.assertEquals(updatedBooking.getFirstname(), "James");
        Assert.assertEquals(updatedBooking.getLastname(), "Brown");
    }

    @Test
    public void partialUpdateBookingTest() {

        given()
                .pathParam("bookingid", bookingid)
                .cookie("token", token)
                .contentType(ContentType.JSON)
                .body(String.format("{\n" +
                        "    \"firstname\" : \"James\",\n" +
                        "    \"lastname\" : \"Brown\"\n" +
                        "}"))
                .when()
                .patch(Endpoints.PATCH_PARTIAL_UPDATE_BOOKING)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();

        Assert.assertEquals(updatedBooking.getFirstname(), "James");
        Assert.assertEquals(updatedBooking.getLastname(), "Brown");
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

    @Test(dependsOnMethods = "deleteBookingTest")
    public void negativeExpectedStatusDeleteBookingTest() {

        given()
                .pathParams("bookingid", bookingid)
                .cookie("token", token)
                .contentType(ContentType.JSON)
                .when()
                .get(Endpoints.GET_BOOKING)
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .log().body();
    }

    @Test
    public void negativeUpdateBookingTest() {
        given()
                .pathParams("bookingid", bookingid)
                .cookie("token", token)
                .contentType(ContentType.JSON)
                .body(String.format("{\n" +
                        "  \"firstname\" : \"Andrey\",\n" +
                        "  \"lastname\" : \"Next\",\n" +
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

        Assert.assertEquals(updatedBooking.getFirstname(), "Andrey");
        Assert.assertEquals(updatedBooking.getLastname(), "Next");
    }

}


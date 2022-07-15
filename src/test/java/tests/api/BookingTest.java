package tests.api;

import baseEntities.BaseAPITest;
import configurations.Endpoints;
import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Epic("Booking example")
@Feature("NFE and AFE booking test")
public class BookingTest extends BaseAPITest {
    public int bookingid;

    @Story("NFE test")
    @Severity(SeverityLevel.CRITICAL)
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

    @Story("NFE test")
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

    @Story("NFE test")
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

    @Story("NFE test")
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

    @Story("NFE test")
    @Test(dependsOnMethods = "deleteBookingTest")
    public void notFoundBookingTest() {

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

    @Story("AFE test")
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

    @Story("AFE test")
    @Test
    public void negativeInvalidBodyUpdateBookingTest() {

        given()
                .pathParams("bookingid", bookingid)
                .cookie("token", token)
                .contentType(ContentType.JSON)
                .body(String.format("{\n" +
                        "  \"firstname\" : \"Andrey\",\n" +
                        "  \"123\" : \"Next\",\n" +
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
}


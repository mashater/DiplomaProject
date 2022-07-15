package tests.api;

import io.qameta.allure.Feature;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Feature("Setting test")
public class HttpClientTest {

    @Test
    public void simpleApiTest() throws IOException {
        String restURL = "http://restful-booker.herokuapp.com";

        // Create Object and pass the url
        HttpUriRequest request = new HttpGet(restURL);

        // send the request
        HttpResponse httpResponse = HttpClientBuilder
                .create()
                .build()
                .execute(request);

        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),
                HttpStatus.SC_OK);

    }
}

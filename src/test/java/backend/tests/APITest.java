package backend.tests;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest {

    String baseUrl = "https://www.analyticsvidhya.com";

    // TC-11: Page Performance API Check
    @Test
    public void validatePublicEndpoint() {
        Response response = RestAssured
                .given()
                .when()
                .get(baseUrl + "/datahack/contest/practice-problem-loan-prediction-iii/")
                .then()
                .extract()
                .response();

        // Validate status code
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200!");

        // Validate response time
        long responseTime = response.getTime();
        Assert.assertTrue(responseTime < 2000, "Response time exceeded 2 seconds!");

        // Log details for debugging
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Time: " + responseTime + "ms");
    }
    // TC-13: HTTPS Security Check
    @Test
    public void validateHttpsAndSecurityHeaders() {
        Response response = RestAssured
                .given()
                .when()
                .get(baseUrl + "/datahack/contest/practice-problem-loan-prediction-iii/")
                .then()
                .extract()
                .response();

        // Validate HTTPS
        Assert.assertTrue(baseUrl.startsWith("https"), "Base URL is not secure (HTTPS)!");

        // Check for basic security headers
        String contentSecurityPolicy = response.getHeader("Content-Security-Policy");
        String strictTransportSecurity = response.getHeader("Strict-Transport-Security");

        Assert.assertNotNull(strictTransportSecurity, "Missing HSTS Header!");
        System.out.println("Strict-Transport-Security: " + strictTransportSecurity);

        if (contentSecurityPolicy != null) {
            System.out.println("Content-Security-Policy: " + contentSecurityPolicy);
        } else {
            System.out.println("Content-Security-Policy not set!");
        }
    }

}


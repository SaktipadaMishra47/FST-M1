package fst.Restassured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {

    private RequestSpecification requestSpecification;  // RequestSpecification object for setting up the request
    private String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIF1epXA9RYsxAbNsB69PKgeDBSJ0/a52tIN7u9cEJeIp"; // SSH key to be added
    private int keyId;  // Variable to store the SSH key ID

    @BeforeClass
    public void setUp() {
        // Set up the request specification
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")  // Base URL
                .addHeader("Authorization", "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")  
                .setContentType("application/json") 
                .build();
    }

    @Test(priority = 1)
    public void postRequest() {
               // Send POST request to /user/keys to add the SSH key
        Response response = RestAssured.given()
                .spec(requestSpecification)  // Use the request specification
                .body("""
						{
		  "title": "TestAPIKey",
          "key"  : "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIF1epXA9RYsxAbNsB69PKgeDBSJ0/a52tIN7u9cEJeIp"
		}
						""")
                .post("/user/keys");

        // Extract the key ID from the response
        keyId = response.jsonPath().getInt("id");

        // Log the response and assert the status code
        Reporter.log("POST Response: " + response.asString());
        Assert.assertEquals(response.getStatusCode(), 201, "POST request failed");

        // Log the SSH key ID for reference
        Reporter.log("SSH Key ID: " + keyId);
    }

    @Test(priority = 2, dependsOnMethods = "postRequest")
    public void getRequest() {
        // Send GET request to fetch the SSH key using the keyId
        Response response = RestAssured.given()
                .spec(requestSpecification)  // Use the request specification
                .pathParam("keyId", keyId)
                .get("/user/keys/{keyId}");

        // Log the response and assert the status code
        Reporter.log("GET Response: " + response.asString());
        Assert.assertEquals(response.getStatusCode(), 200, "GET request failed");
    }

    @Test(priority = 3, dependsOnMethods = "getRequest")
    public void deleteRequest() {
        // Send DELETE request to remove the SSH key using the keyId
        Response response = RestAssured.given()
                .spec(requestSpecification)  // Use the request specification
                .pathParam("keyId", keyId)
                .delete("/user/keys/{keyId}");

        // Log the response and assert the status code
        Reporter.log("DELETE Response: " + response.asString());
        Assert.assertEquals(response.getStatusCode(), 204, "DELETE request failed");
    }
}

package fst.Restassured;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Activity2 {
	String baseURL = "https://petstore.swagger.io/v2/user";
	Response response;
	String userName = "";
	
	@Test(priority = 1)
	public void addNewUserFromFile() throws FileNotFoundException {
	    System.out.println("*****************Create Starts **********************");

	    // File path to the JSON file
	    String filePath = System.getProperty("user.dir") + "/user.json";
	    
	    try {
	        // Read the content of the JSON file into a string
	        String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
	        System.out.println(jsonString);  // Optionally print the JSON content

	        // Parse the JSON content into a JSONObject
	        JSONObject jsonObject = new JSONObject(jsonString);

	        // Retrieve the username from the JSON object
	        userName = jsonObject.getString("username");
	        System.out.println("Username: " + userName);

	        // Use the JSON string for the body in the POST request
	        response = RestAssured.given()
	                .baseUri(baseURL)
	                .log().all()
	                .contentType("application/json")
	                .body(jsonString)  // Pass the JSON string directly here
	                .post()
	                .then()
	                .log().all()
	                .extract().response();

	        // Extract response JSON path
	        JsonPath jsonResponse = response.jsonPath();

	        // Assert the expected status code and response message
	        Assert.assertEquals(response.getStatusCode(), 200);
	        Assert.assertEquals(jsonResponse.getString("message"), "9804");

	    } catch (IOException e) {
	        e.printStackTrace();
	        // Handle exception (e.g., log the error, rethrow, etc.)
	    }
	}
	
	@Test(priority=2)
	public void getPet() {
	    System.out.println("*****************Get Starts **********************");
	    
	    // Create output file to write response
	    File outputJSON = new File(System.getProperty("user.dir") + "/userGETResponse.json");

	    // Send GET request
	    response = RestAssured.given()
	            .baseUri(baseURL)
	            .log().all()
	            .contentType("application/json")
	            .get("/Jack")
	            .then()
	            .log().all()
	            .extract().response();

	    // Get the response body as a pretty string
	    String resBody = response.getBody().asPrettyString();
	    
	    // Extract response values using JsonPath
	    JsonPath jsonResponse = response.jsonPath();

	    // Assert the status code and response values
	    Assert.assertEquals(response.getStatusCode(), 200); // Check for successful response
	    Assert.assertEquals(jsonResponse.getString("username"), "Jack");  // Assert the username
	    Assert.assertEquals(jsonResponse.getInt("id"), 9804);  // Assert the ID
	    Assert.assertEquals(jsonResponse.getString("firstName"), "Jacklin");
	    Assert.assertEquals(jsonResponse.getString("lastName"), "farnandez");
	    Assert.assertEquals(jsonResponse.getString("email"), "Jack@mail.com");
	    Assert.assertEquals(jsonResponse.getString("password"), "password123");
	    Assert.assertEquals(jsonResponse.getString("phone"), "9813763450");

	    try {
	        // Create new file if it doesn't exist
	        if (!outputJSON.exists()) {
	            outputJSON.createNewFile();
	        }

	        // Write response body to file
	        try (FileWriter writer = new FileWriter(outputJSON)) {
	            writer.write(resBody);
	        }

	    } catch (IOException excp) {
	        excp.printStackTrace();
	    }
	}
	
	@Test(priority=3)
	public void deleteUser() throws IOException {
		System.out.println("*****************Delete Starts **********************");
		Response response = RestAssured.given()
			.baseUri("https://petstore.swagger.io/v2/user") // Set base URI
			.header("Content-Type", "application/json").log().all() // Set headers
			.pathParam("username", "Jack") // Add path parameter
			.when().log().all().delete("/{username}"); // Send POST request
 
		// Extract response JSON path
        // Assert the expected status code and response message
        Assert.assertEquals(response.getStatusCode(), 200);
        
	}
}

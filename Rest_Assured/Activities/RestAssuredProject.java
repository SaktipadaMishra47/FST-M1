package project;

import static io.restassured.RestAssured.given;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredProject {
	
	RequestSpecification requestSpec;
	String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIBV+NygSuuQ+p29VDwuM047ZZmGX1pFV1xOE+Jp/yowD";
	int sshKey_ID;
	
	@BeforeClass
	public void setup() {
		requestSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.addHeader("Authorization", "token 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")
				.setBaseUri("https://api.github.com")
				.build();
	}
	
	@Test(priority=1)
	public void testPostRequest() {
		String requestBody = """
				{
				"title": "TestAPIKey",
				"key": "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIBV+NygSuuQ+p29VDwuM047ZZmGX1pFV1xOE+Jp/yowD"
				}
				""";
		
		Response postResponse = 
				given().spec(requestSpec).body(requestBody)
				.when().post("/user/keys");
				
		sshKey_ID = postResponse.then().extract().jsonPath().getInt("id");
		postResponse.then().statusCode(201);
	}
	
	@Test(priority=2)
	public void testGetRequest() {
		Response getResponse = given()
				.spec(requestSpec)
				.when().pathParam("keyId", sshKey_ID)
				.get("/user/keys/{keyId}");
		
		Reporter.log(getResponse.asPrettyString());
		getResponse.then().statusCode(200);
	}
	
	@Test(priority=3)
	public void testDeleteRequest() {
		
		Response deleteResponse = given()
				.spec(requestSpec)
				.when().pathParam("keyId", sshKey_ID)
				.delete("/user/keys/{keyId}");
		
		Reporter.log(deleteResponse.asPrettyString());
		deleteResponse.then().statusCode(204);
	}
}

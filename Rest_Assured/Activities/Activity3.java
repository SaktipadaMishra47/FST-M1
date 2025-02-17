package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity3 {
	String baseUri = "https://petstore.swagger.io/v2/pet";
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;

	@BeforeClass
	public void setup() {
		requestSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.setBaseUri(baseUri)
				.build();

		responseSpec = new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.expectStatusCode(200)
				.expectBody("status", equalTo("alive"))
				.build();
	}
	
	@DataProvider(name = "petInfo")
	public Object[][] dataProvider(){
		Object[][] testData = new Object[][] {
			{ 77232, "Riley", "alive" }, 
			{ 77233, "Hansel", "alive" } 
		};		
		return testData;
	}

	@Test(priority = 1)
	public void postRequestTest() {
		String pet1Body = """
				{
				"id": 77232,
				"name": "Riley",
				"status": "alive"
				}
				""";

		String pet2Body = """
				{
				"id": 77233,
				"name": "Hansel",
				"status": "alive"
				}
				""";

		Response pet1Response = 
				given().spec(requestSpec).body(pet1Body)
				.when().post();

		Response pet2Response = 
				given().spec(requestSpec).body(pet2Body)
				.when().post();

		pet1Response.then().spec(responseSpec);
		pet2Response.then().spec(responseSpec);
	}

	@Test(dataProvider = "petInfo", priority = 2)
	public void getRequestTest(int petId, String name, String status) {		
		Response getResponse = given()
				.spec(requestSpec)
				.when().pathParam("petId", petId)
				.get("/{petId}");

		getResponse.then().spec(responseSpec);
		
		getResponse.then().body("id", equalTo(petId));
		getResponse.then().body("name", equalTo(name));
	}

	@Test(dataProvider = "petInfo", priority = 3)
	public void deleteRequestTest(int petId, String name, String status) {		
		Response deleteResponse = given()
				.spec(requestSpec)
				.when().pathParam("petId",petId)
				.delete("/{petId}");

		deleteResponse.then().statusCode(200);
		deleteResponse.then().body("message",equalTo(petId+""));
	}
}

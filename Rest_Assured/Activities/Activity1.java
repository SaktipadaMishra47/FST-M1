package fst.Restassured;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.*;
import io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

public class Activity1 {

	String baseURL = "https://petstore.swagger.io/v2/pet";
	Response response;
	int petId = 0;

	@Test(priority = 1)
	public void createNewPet() {
		System.out.println("*****************Create Starts **********************");
		
		response = RestAssured.given().baseUri(baseURL).log().all().contentType("application/json").body("""
								{
				  "id": 77232,
				  "name": "Riley",
				  "status": "alive"
				}
								""").post().then().log().all().extract().response();
		JsonPath jsonResponse = response.jsonPath();
		
		petId = jsonResponse.getInt("id");
		
		System.out.println("petId is " +petId);
		Assert.assertEquals(petId, 77232);
		Assert.assertEquals(jsonResponse.getString("name"), "Riley");
		Assert.assertEquals(jsonResponse.getString("status"), "alive");

	}
	@Test(priority=2)
	public void getPet() {
		System.out.println("*****************get Starts **********************");
		
		response = RestAssured.given().baseUri(baseURL).log().all().contentType("application/json").
				get("/"+petId).then().log().all().extract().response();
		JsonPath jsonResponse = response.jsonPath();
		petId = jsonResponse.getInt("id");
		Assert.assertEquals(petId, 77232);
		Assert.assertEquals(jsonResponse.getString("name"), "Riley");
		Assert.assertEquals(jsonResponse.getString("status"), "alive");

	}
	
	@Test(priority =3)
	public void deletePet() {
		System.out.println("*****************delete Starts **********************");
		
		response = RestAssured.given().baseUri(baseURL).log().all().contentType("application/json").
				delete("/"+petId).then().log().all().extract().response();
		
		Assert.assertEquals(response.getStatusCode() ,200 );
		Assert.assertEquals(petId,77232,"Unable to delte the code");	
	}	
}

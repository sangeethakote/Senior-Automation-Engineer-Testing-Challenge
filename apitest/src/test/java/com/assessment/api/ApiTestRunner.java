package com.assessment.api;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import java.util.List;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiTestRunner{

	String base_url ="https://api.airvisual.com/v2/";
	String auth_key = "30df8bfb-d136-402b-a068-78ea50c33475";
	String latitude = "";
	String longitude = "";
	
	
	@Test(priority = 0)
	public void responsecode_validation() {
		Response response = RestAssured.given().
				queryParam("country","Australia").
				queryParam("key","").
				when().
				get(base_url+"states");		
		//Status code validation - 403 Forbidden
		Assert.assertEquals(response.getStatusCode(), 403);

		response = RestAssured.given().
				queryParam("country","Australia").
				queryParam("key",auth_key).
				when().
				get(base_url+"states");		
		//Status code validation - 200 OK
		Assert.assertEquals(response.getStatusCode(), 200);

	}
	
	@Test(priority = 1)
	public void states_validation() {
		Response response = RestAssured.given().
				queryParam("country","Australia").
				queryParam("key",auth_key).
				when().
				get(base_url+"states");		
		
		
		List<String> jsonResponse = response.jsonPath().getList("data.state");
		//Validate 6 states of Australia
		Assert.assertEquals(jsonResponse.size(), 6);
		
		//6 states of Australia - validate names
		Assert.assertEquals(jsonResponse.get(0),"New South Wales");
		Assert.assertEquals(jsonResponse.get(1),"Queensland");
		Assert.assertEquals(jsonResponse.get(2),"South Australia");
		Assert.assertEquals(jsonResponse.get(3),"Tasmania");
		Assert.assertEquals(jsonResponse.get(4),"Victoria");
		Assert.assertEquals(jsonResponse.get(5),"Western Australia");
		
	}
	
	@Test(priority = 2)
	public void nearestcity_validation() {
		Response response = RestAssured.given().
				queryParam("key",auth_key).
				when().
				get(base_url+"nearest_city");
		
		Assert.assertEquals(response.getStatusCode(), 200);
		longitude = response.jsonPath().getString("data.location.coordinates[0]");
		latitude = response.jsonPath().getString("data.location.coordinates[1]");		
	}
	
	@Test(priority = 3)
	public void nearestcity_with_cordinates_validation() {
		Response response = RestAssured.given().
				queryParam("lat",latitude).
				queryParam("lon",longitude).
				queryParam("key",auth_key).
				when().
				get(base_url+"nearest_city");
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//Getting the temperature
		String temperature = response.jsonPath().getString("data.current.weather.tp");
		System.out.println("temperature : "+temperature);
		
		//Validate json format
		RestAssured.given().
		queryParam("lat",latitude).
		queryParam("lon",longitude).
		queryParam("key",auth_key).
		when().
		get(base_url+"nearest_city")
        .then()
        .assertThat()
        .body(matchesJsonSchemaInClasspath("JsonSchemaFile.json"));
		
	}
	
}

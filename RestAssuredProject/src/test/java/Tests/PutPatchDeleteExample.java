package Tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExample {
	
	
	@Test
	public void test_Put() {
		
		baseURI = "https://reqres.in/api";
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Devender");
		request.put("job", "Teacher");
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200)
			.log().all();
	}
	
	@Test
	public void test_Patch() {
		
		baseURI = "https://reqres.in/api";
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Devender");
		request.put("job", "Teacher");
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/users/2").
		then().
			statusCode(200)
			.log().all();
	}
	
	@Test
	public void test_Delete() {
		
		baseURI = "https://reqres.in";
					
		when().
			patch("/api/users/2").
		then().
			statusCode(200)
			.log().all();
	}

}

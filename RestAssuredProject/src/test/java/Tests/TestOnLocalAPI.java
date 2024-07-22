package Tests;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestOnLocalAPI {
	
	
	//@Test
	public void test_get() {
		
		baseURI = "http://localhost:3000";
		
		given().
			get("/users").
		then().
			statusCode(200).
			log().all();
	}
	
	//@Test
	public void test_Post() {
		
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "John");
		request.put("lastName", "Salter");
		request.put("subjectId", 1);
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201)
			.log().all();
	}
	
	//@Test
	public void test_Put() {
		
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Senthil");
		request.put("lastName", "Sent");
		request.put("subjectId", 2);
		request.put("id", 4);
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/f1ff").
		then().
			statusCode(200)
			.log().all();
	}
	
	//@Test
	public void test_Patch() {
		
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		
		request.put("lastName", "Doe");
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/users/f1ff").
		then().
			statusCode(200)
			.log().all();
	}
	
	@Test
	public void test_delete() {
		
		baseURI = "http://localhost:3000";
		
		when().
			delete("/users/f1ff").
		then().
			statusCode(200)
			.log().all();
	}

}

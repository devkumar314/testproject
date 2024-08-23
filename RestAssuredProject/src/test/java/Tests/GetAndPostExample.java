

package Tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAndPostExample {
	
	@Test
	public void test_get() {
		
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name", equalTo("George")).
			body("data.first_name", hasItems("George","Rachel"))
			.log().all();
	}
	

	
	@Test
	public void test_map() {
		
		baseURI = "https://reqres.in/api";
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", "Devender");
		map.put("job", "Teacher");
		
		System.out.println(map);
		
	}
	
	@Test
	public void test_mapJSON() {
		
		baseURI = "https://reqres.in/api";
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", "Devender");
		map.put("job", "Teacher");
		
		System.out.println(map);
		
		JSONObject request = new JSONObject(map);
		System.out.println(request);
		System.out.println(request.toJSONString());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test_Post() {
		
		baseURI = "https://reqres.in/api";
		
		//Map<String, Object> map = new HashMap<String, Object>();
		//map.put("name", "Devender");
		//map.put("job", "Teacher");
		//System.out.println(map);
		//JSONObject request = new JSONObject(map);
		
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
			post("/users").
		then().
			statusCode(201)
			.log().all();
	}
	
	
}


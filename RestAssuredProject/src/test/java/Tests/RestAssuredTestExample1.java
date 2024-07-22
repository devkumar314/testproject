package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredTestExample1 {

	@Test
	public void test_1() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println();
		System.out.println("Response Code - "+ response.getStatusCode());
		System.out.println("Response Time -  "+ response.getTime());
		System.out.println("Response Body -  "+ response.getBody().asPrettyString());
		System.out.println("Status Line -  "+ response.getStatusLine());
		System.out.println("Header -  "+ response.getHeader("content-type"));
		System.out.println("Header All -  "+ response.getHeaders());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test
	public void test_2() {
		
		baseURI = "https://reqres.in/api";
		
		given().get("/users?page=2").then().statusCode(200);
	}
	
	@Test
	public void test_3() {
		
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[1].id", equalTo(8))
			.log().all();
	}
	
	
}

package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class TestExample1 {

	@Test
	public void test_1() {
		
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println();
		System.out.println("Response Code - "+ response.getStatusCode());
		System.out.println("Response Time -  "+ response.getTime());
		System.out.println("Response Body -  "+ response.getBody().asPrettyString());
		System.out.println("Status Line -  "+ response.getStatusLine());
		System.out.println("Header -  "+ response.getHeader("content-type"));
		System.out.println("Header All -  "+ response.getHeaders());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Response response1 = given()
			    				.get("https://reqres.in/api/users?page=2")
			    			.then()
			    				.extract()
			    				.response();
			JsonPath jsonPath = response1.jsonPath();
			String name = jsonPath.get("name");
			int age = jsonPath.get("age");
			
			System.out.println("Name - "+ name);
			System.out.println("Age - "+ age);

	}
}

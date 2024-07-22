package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

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
	}
}

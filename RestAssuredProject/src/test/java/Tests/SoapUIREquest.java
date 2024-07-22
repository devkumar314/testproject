package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SoapUIREquest {
	
	
	@Test
	public void validateSoapXML() throws IOException {
		
		File file = new File("./SoapRequest/Add.xml");
		if(file.exists())
			System.out.println(" >> file exists");
		else
			System.out.println(" >> file not exists"); 
		
		FileInputStream fileInputStream= new FileInputStream(file);
		String requestbody = IOUtils.toString(fileInputStream, "UTF-8");
		
		
		baseURI = "http://xyz.com";
		
		given().
			contentType(ContentType.XML).
			accept(ContentType.JSON).
			body(requestbody).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all().
		and().
			body("//*.:AddResult.text()", equalTo("5"));
		
		//AddResult -> tag name and value is 5
	}

}

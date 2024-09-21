package Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ZTest {

	public static void main(String[] args) {
		
		//baseURI = "https://reqres.in";
		tryExample();		
							
		 Response response = RestAssured
		            .given()
		            .baseUri("https://reqres.in")
		            .basePath("/api/users")
		            .queryParam("page", 2)
		            .when()
		            .get()
		            .then()
		            .statusCode(200)
		            .log().all()
		            .body("total_pages", equalTo(2))
		            .body("data[0].id", equalTo(7))
		            .body("data.find{it.id==7}.first_name", equalTo("Michael"))
		            .extract()
		            .response();
		 
		 System.out.println(response.asPrettyString());
		 JsonPath jsonPath = response.jsonPath() ;
		 
		 System.out.println(jsonPath.get("total_pages").toString());
		 System.out.println(jsonPath.get("support.url").toString());
		 
		 System.out.println(jsonPath.get("data[0].id").toString());
		 
		 
		 String fs = jsonPath.get("data[0].first_name");
		 System.out.println(fs);
		 
		 List<String> alName = jsonPath.get("data.first_name");
		 System.out.println(alName.toString());
		 
		 Map<String, String> map= jsonPath.getMap("data[0]");
		 System.out.println(map.toString());
		 
		 List<Map<String, String>> listData= jsonPath.getList("data");
		 System.out.println(listData.toString());
		 
		 boolean isB = listData.stream()
				 .anyMatch(n -> n.get("first_name").contains("test") && n.get("email").contains("michael"));
		 System.out.println(isB);
		 
		 List<Map<String, String>> listT = listData.stream().filter(n -> n.get("first_name").contains("Michael"))
		 	.collect(Collectors.toList());
		 System.out.println(listT.toString());
		 
		 /*
		 int searchId = 7;
		 Optional<Map<String, String>> result = listData.stream()
		            .filter(n -> n.get("id").toString().equals(String.valueOf(searchId)))
		            .findFirst();
				 //.collect(Collectors.toList());
		 
				 System.out.println(result.toString());
			*/	 
				 
		List<Map<String,String>> sData = jsonPath.getList("data");
		System.out.println(sData.toString());
		boolean isData = sData.stream()
				.anyMatch(n -> n.get("first_name").contains("Michael") && n.get("last_name").contains("Lawson"));
		 System.out.println(isData);
		 
		 List<Map<String, String>> listID = listData.stream().filter(n -> n.get("id") == String.valueOf(7))
				 	.collect(Collectors.toList());
				 System.out.println(listID.toString());
	}
	
	public static void tryExample() {
		
		
		Response response = RestAssured.given()
							.baseUri("https://reqres.in")
							.basePath("/api/users")
							.queryParam("page", 2)
							.contentType(ContentType.JSON)
							.accept("json")
							.when()
							.get()
							.then()
							.statusCode(200)
							.log().all()
							.body("total_pages", equalTo(2))
							.body("support.text", containsString("keep"))
							.extract()
							.response();
		
		JsonPath jsonPath = response.jsonPath();
		
		List<String> firstNames = jsonPath.getList("data.first_name");
		System.out.println(firstNames.toString());
		
		Map<String, Object> map = jsonPath.getMap("data[0]");
		System.out.println(map.toString());
		
		System.out.println(jsonPath.getString("support.url"));
		
							
	}
}

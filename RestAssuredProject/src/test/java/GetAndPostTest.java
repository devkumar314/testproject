import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAndPostTest {

	
	@Test
	public void test_get1() {
		
		given().contentType(ContentType.JSON).when().get("http://localhost:3000/posts").then().header(DEFAULT_PATH, DEFAULT_BODY_ROOT_PATH)
		
	}
	
}

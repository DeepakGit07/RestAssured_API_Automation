import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_007_GET {
	@Test
	public void validateJsonBody() {
		RestAssured.baseURI = "https://reqres.in/api/unknown";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET);
		String body = response.getBody().asString();
		System.out.println(body);
		JsonPath jsonpath = response.jsonPath();
		int total_pages = jsonpath.get("total_pages");
		System.out.println(total_pages);
		Assert.assertEquals(total_pages, 2);
		System.out.println(jsonpath.get("data.Name"));
		
		
		
		
		
		
	}

}

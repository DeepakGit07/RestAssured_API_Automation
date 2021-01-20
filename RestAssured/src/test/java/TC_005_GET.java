import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_005_GET {
	@Test
	public void validateHeaders() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET);
		String server = response.header("server");
		System.out.println(server);
		Assert.assertEquals(server, "cloudflare");
		String powered = response.getHeader("x-powered-by");
		System.out.println(powered);
		Assert.assertEquals(powered, "Express");
		
		
		
		
	}

}

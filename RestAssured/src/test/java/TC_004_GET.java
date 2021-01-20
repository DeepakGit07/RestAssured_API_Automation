import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_004_GET {
	@Test
	public void getmethod() {
		RestAssured.baseURI = "https://reqres.in/api/users/2";
		RequestSpecification getrequest = RestAssured.given();
		Response response = getrequest.request(Method.GET);
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 200);
		
		
	}

}

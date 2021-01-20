import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_001_GET {
	@Test
	public void getStatusCodeandLine() {
		//For GET Request first we have to give base URL
		RestAssured.baseURI="https://reqres.in/api/users/";
		//Then create an object to pass request merhod
		RequestSpecification httprequest = RestAssured.given();
		//use the object to pass request and create object to store response
		Response response = httprequest.request(Method.GET, "/2");
		//print Response
		int status = response.getStatusCode();
		System.out.println("Status code is:" + status);
		String line = response.getStatusLine();
		System.out.println("Status Line is:" + line);
		String body = response.getBody().asString();
		System.out.println("response body is" + body);
		//Validate Response
		Assert.assertEquals(status, 200);
		Assert.assertEquals(line, "HTTP/1.1 200 OK");
		
		
		
		
		
		
	}

}

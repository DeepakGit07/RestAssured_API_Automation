import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_006_GET {
	@Test
	public void getallheaders() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		RequestSpecification getrequest = RestAssured.given();
		Response response = getrequest.request(Method.GET);
		Headers allheaders = response.getHeaders();
		for(Header headers:allheaders) {
			System.out.println(headers.getName() +"         " +headers.getValue());
		}
		System.out.println(allheaders);
		
		
		
	}
	

}

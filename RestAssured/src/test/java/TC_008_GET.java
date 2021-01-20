import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveAuthProvider;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_008_GET {
	@Test
	public void authentication() {
		RestAssured.baseURI = "https://reqres.in/api/login";
		RequestSpecification authrequest = RestAssured.given();
		//create class to pass authenticatiomn
		PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
		auth.setUserName("Deepak");
		auth.setPassword("vuk12345");
		RestAssured.authentication = auth;
		Response response = authrequest.request(Method.GET);
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		
		
		
		
	}

}

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_002_POST {
	@Test
	public void postmethod() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		RequestSpecification httprequest = RestAssured.given();
		//create jsonobject class to pass messagebody in json format
		JSONObject requestbody = new JSONObject();
		requestbody.put("name", "morpheus");
		requestbody.put("job", "leader");
		//httprequest.header("content-type", "application/json");
		httprequest.body(requestbody.toJSONString());
		Response response = httprequest.request(Method.POST);
		String resbody = response.getBody().asString();
		System.out.println("Response Body is : " +resbody);
		int statuscode = response.getStatusCode();

		System.out.println("Status Code is : " +statuscode);
		String sucesscode = response.jsonPath().get("sucesscode");
		System.out.println("sucess code is : " + sucesscode);
		Assert.assertEquals(statuscode, 201);
		//Assert.assertEquals(sucesscode, "null");
		
		
		
		
		
		
		
		
		
		
		
		
				
			
		
		
		
	}
	

}

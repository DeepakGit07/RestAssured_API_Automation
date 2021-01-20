import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_003_POST {
	@Test
	public void postmethod() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		RequestSpecification httprequest = RestAssured.given();
		JSONObject requestbody = new JSONObject();
		requestbody.put("name", "morpheus");
		requestbody.put("leader", "leader");
		httprequest.header("content-type", "application/json");
		httprequest.body(requestbody.toJSONString());
		Response response = httprequest.request(Method.POST);
		
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		
		
	}

}

package DataDrivenTesting;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_001_XL {
	
	@Test(dataProvider = "empdataprovider")
	public void getDataFromXl() {
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		RequestSpecification httprequest = RestAssured.given();
		JSONObject data = new JSONObject();
		data.put("name", "ename");
		data.put("job", "ejob");
		httprequest.headers("content-type", "application/json");
		httprequest.body(data.toJSONString());
		Response response = httprequest.request(Method.POST);
		int statuscode = response.getStatusCode();
		String body = response.getBody().asString();
		System.out.println(statuscode);
		System.out.println(body);
		
		
		}
		@DataProvider(name = "empdataprovider")
		String [][] getempdata() throws IOException {
			
			String path = System.getProperty("/Users/deepakvukanti/Documents/Projects/RestAssured/src/test/java/DataDrivenTesting/data.xlsx");
			int rowcount = Exutility.getRowCount(path, "sheet1");
			int colcount = Exutility.getCellCount(path, "sheet1", 1);
			String empdata [][] = new String[rowcount][colcount];
			for (int i =1; i<rowcount; i++) {
				for(int j = 0; j<colcount; j++) {
					empdata[i - j][j] = Exutility.getCellData(path, "sheet1", i, j);
					
				}
				
			}
			return empdata;
			
		}

}

package webServicesTestCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC1_GET_Request {

	@Test
	public void getWeatherDetails(){
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";  // ""
		
		RequestSpecification httpreq=RestAssured.given();
		Response resp=httpreq.request(Method.GET, "/hyderabad");		//GET request
		
		String respbody=resp.getBody().asString();
		System.out.println("Respnse Body : \n"+respbody );
		
		int stateCode=resp.getStatusCode();	//Status code
		
		String stateLine=resp.getStatusLine();
		System.out.println(stateLine);
		
		
		Assert.assertEquals(stateLine, "HTTP/1.1 200 OK");
		Assert.assertEquals(stateCode, 200);
		
	}
	
}

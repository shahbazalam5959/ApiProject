package DemoRequest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC002_POST_Request {

	@Test
	public void registrationSucessful()
	{
		
		RestAssured.baseURI="https://reqres.in/";
		
		//Request Object
		RequestSpecification httprequest = RestAssured.given();
		
		//Request payload sending along with the post request
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("name", "Md Shahbaz Alam");
		requestParams.put("job", "AE");
		
		httprequest.header("Content-Type","application/json");
		
		httprequest.body(requestParams.toJSONString());  // attach above data to the request
		
		Response response = httprequest.request(Method.POST,"/api/users");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response body is :"+responseBody);
		
		int code = response.getStatusCode();
		System.out.println("Status code is : "+code);
		Assert.assertEquals(code, 201);
		
		//SuccessCode Validation
		String MyName = response.jsonPath().get("name");
		Assert.assertEquals(MyName, "Md Shahbaz Alam");
		
	}
	
}

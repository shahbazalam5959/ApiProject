package DemoRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_004_ValidatingJSON_Response {

	@Test
	public void JSONResponse()
	{
		//Specify Base URI
		RestAssured.baseURI="https://reqres.in/";
		
		//Creating Request Object
		RequestSpecification httprequest = RestAssured.given();
		
		//Sending request and storing the response in resp variable
		Response resp = httprequest.request(Method.GET,"/api/users/2");
		
		//Validating Status code
		int code = resp.getStatusCode();
		System.out.println("Status code is : "+code);
		Assert.assertEquals(code, 200);
		
		//Printing & Validating response to the console
		System.out.println("Response Body "+resp.getBody().asString());
		Assert.assertEquals(resp.getBody().asString().contains("janet.weaver@reqres.in"), true);
		
		//Capture all headers from response
		Headers allheader = resp.headers();
		for(Header header:allheader)
		{
			System.out.println(header.getName()+"      ->   "+header.getValue());
		}
		
	}
	
}

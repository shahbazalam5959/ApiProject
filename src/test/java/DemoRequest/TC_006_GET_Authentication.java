package DemoRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_006_GET_Authentication {

	@Test
	public void AuthenticationTest()
	{
		//Base URI(ToolsQA)
		RestAssured.baseURI="https://restapi.demoqa.com/authentication/CheckForAuthentication";  
		
		//providing basicAuth
		PreemptiveBasicAuthScheme AuthScheme = new PreemptiveBasicAuthScheme();
		AuthScheme.setUserName("ToolsQA");
		AuthScheme.setPassword("TestPassword");
		
		RestAssured.authentication=AuthScheme;
		
		RequestSpecification httprequest = RestAssured.given();
		
		Response resp = httprequest.request(Method.GET,"/");  //'/' represen the HomePage
		
		System.out.println("Response Body is : "+resp.getBody().asString());
		
		int code = resp.getStatusCode();
		System.out.println("Status Code is : "+code);
		Assert.assertEquals(code, 200);
	}
	
}
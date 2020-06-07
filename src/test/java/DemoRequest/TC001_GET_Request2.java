package DemoRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request2 {

		@Test
		public void getweatherDetails()
		{
			//Specify BaseURI
			RestAssured.baseURI="https://reqres.in/";
			
			//Request Object
			RequestSpecification httprequest = RestAssured.given();
			
			//Response Object
			Response resp = httprequest.request(Method.GET,"/api/users/2");
			
			//Print response in console window
			String respBody = resp.getBody().asString();
			System.out.println("Response Body is :"+respBody);
			
			//Status Code Validation
			int code = resp.getStatusCode();
			System.out.println("Staus Code is : "+code);
			Assert.assertEquals(code, 200);
			
			//Status Line Verification
			String statusLine = resp.getStatusLine();
			System.out.println("Status Line is : "+statusLine);
			Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
			
			//Content Verification OR Validating Headers
			String ContentType = resp.header("content-type");  //Capture Content details of headers from response
			System.out.println("Conent Type is : "+ContentType);
			Assert.assertEquals(ContentType, "application/json; charset=utf-8");
			
			//Server Verification OR Validating Headers
			String servr = resp.header("server");  //Capture server details of headers from response
			System.out.println("Server Name is : "+servr);
			Assert.assertEquals(servr, "cloudflare");
			
		}
		
}

package DemoRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request_PrintAllHeaders {

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
			
			Headers allheaders = resp.headers();   // Capture all the Headers from Response
			
			for(Header header:allheaders) 
			{
				System.out.println(header.getName()+ " ->  " +header.getValue() );
				
			}
			
		}
		
}

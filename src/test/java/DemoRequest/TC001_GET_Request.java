package DemoRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {

		@Test
		public void getweatherDetails()
		{
			//Specify BaseURI
			RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
			
			//Request Object
			RequestSpecification httprequest = RestAssured.given();
			
			//Response Object
			Response resp = httprequest.request(Method.GET,"/Bangalore");
			
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
			
		}
		
}

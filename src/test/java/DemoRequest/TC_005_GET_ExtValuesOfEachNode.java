package DemoRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_005_GET_ExtValuesOfEachNode {

	@Test
	public void JSONResponse()
	{
		//Specify Base URI
		RestAssured.baseURI="https://reqres.in";
		
		//Creating Request Object
		RequestSpecification httprequest = RestAssured.given();
		
		//Sending request and storing the response in resp variable
		Response resp = httprequest.request(Method.GET,"/api/users/3");
		
		//This Resp.jsonPath will capture the path of json as it is & store in jsonpath variable
		JsonPath path = resp.jsonPath();
		
		System.out.println(path.get("data.id"));	
		System.out.println(path.get("data.email"));
		System.out.println(path.get("data.first_name"));
		System.out.println(path.get("data.last_name"));
		System.out.println(path.get("data.avatar"));
		
		
		System.out.println(path.get("ad.company"));
		System.out.println(path.get("ad.url"));
		System.out.println(path.get("ad.text"));
	}
	
}
// This project has been added to github

//For API/WebServices Testing they prepare interactive document using SwaggerUI Tool(used for API Documentation. 
//We can explore the Api functionaltiy inSwaggerUI -Developer will prepare this document based on the requirement
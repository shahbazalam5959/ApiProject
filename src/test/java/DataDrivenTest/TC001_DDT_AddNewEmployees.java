package DataDrivenTest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_DDT_AddNewEmployees {

	@Test(dataProvider="empDataProvider")
	public void postNewEmployees(String ename,String esal,String eage)
	{
	
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		//Here we created data which we can send along with the post request
		JSONObject requestParams =new JSONObject();
		
		requestParams.put("name", ename);
		requestParams.put("salary", esal);
		requestParams.put("age", eage);
		
		//Add a header stating the request body is a JSON
		httpRequest.header("Content-Type","application/json");
		
		//Add a json to the body of the request
		httpRequest.body(requestParams.toJSONString());
		
		//POST Request
		Response resp = httpRequest.request(Method.POST,"/create");
		
		//Capture Response body
		String responseBody = resp.getBody().asString();
		
		System.out.println("Response Body is : "+responseBody);
		
		Assert.assertEquals(responseBody.contains(ename), true);
		Assert.assertEquals(responseBody.contains(esal), true);
		Assert.assertEquals(responseBody.contains(eage), true);

		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
}	


	@DataProvider(name="empDataProvider")
	String [][] getEmpData(){
		
		ExcelDataProvider dataProvider = new ExcelDataProvider();
		
		int rownum = dataProvider.getRowCount("Sheet1");
		int colnum = dataProvider.getCellCount("Sheet1", 1);
		
		String empdata[][] = new String[rownum][colnum];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				empdata[i-1][j]=(String) dataProvider.getExcelData("Sheet1", i, j);
			}
		}
		
		return empdata;
	}


}

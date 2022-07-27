package com.employeeapi.testCases;
import java.io.IOException;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.employeeapi.utilities.XLUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTesting {

	// Prepare test data in excel
	// Add Apache Poi dependency in pom.xml or add jars manually through build path
	// XL Utility file (Java class file) which will read data from excel
	// Write testNG test with DataProvider method
	
	@Test(dataProvider = "empdataprovider")
	void postNewEmployees(String ename, String esalary, String eage)
	{
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject jsO = new JSONObject();
		jsO.put("name", ename);
		jsO.put("salary", esalary);
		jsO.put("age", eage);
		
		httpRequest.body(jsO.toJSONString());
		httpRequest.header("Content-type", "application/json");
		
		Response response = httpRequest.request(Method.POST, "/create");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		Assert.assertEquals(true, responseBody.contains("success"));
		
		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertEquals(responseBody.contains(ename), true);
		Assert.assertEquals(responseBody.contains(esalary), true);
		Assert.assertEquals(responseBody.contains(eage), true);
	}
	
	@DataProvider(name = "empdataprovider")
	String[][] getEmpData() throws IOException
	{	
		System.out.println(System.getProperty("user.dir"));
		
		String path = "C:/Users/Mamta/eclipse-workspace/RestAssuredAPITesting/src/test/java/empdata.xlsx";
		
		int rowNum = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", rowNum);
		//String[][] empData = {{"mahesx", "300000", "40"}, {"mahesy", "40000", "50"}, {"mahesz", "30000", "30"}};
		
		String[][] empData = new String[rowNum][colCount];
		
		for(int i=0; i<rowNum; i++)
		{
			for(int j=0; j<colCount; j++)
			{
				empData[i][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return(empData);
	}
}

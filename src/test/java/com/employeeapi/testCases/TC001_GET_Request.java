package com.employeeapi.testCases;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	
	@Test
	void getWeatherDetails()
	{
		// Specify Base URL
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/todos";
		
		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		// Response Object
		Response response = httpRequest.request(Method.GET, "/1");
		
		// Print Response in console window
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		int statusCode = response.statusCode();
		System.out.println("Status Cdoe : " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		String statusLine = response.statusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		
	}
	
}

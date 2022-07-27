package com.employeeapi.testCases;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request {
	
	@Test
	void googleMapTest()
	{
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.867"
				+ "0522.151.1957362&radius=1500&type=supermarket&key=AIzaSyBuTkfVmfZYnrRI7-P_stoNRS3fQUSN0oI");
		
		System.out.println(response.getBody().asString());
		
	}
}

package com.employeeapi.testCases;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	
	@Test
	void registrationSuccessful()
	{
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Basic Auth
		PreemptiveBasicAuthScheme authentication = new PreemptiveBasicAuthScheme();
		authentication.setUserName("UserName");
		authentication.setPassword("Password");
		RestAssured.authentication = authentication;
		
		// Request Payload
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("userId", "200");
		requestParams.put("title", "Testing RestAuured");
		requestParams.put("body", "Testing RestAssured Body");
		
		httpRequest.header("Content-type", "application/json; charset=UTF-8");
		httpRequest.body(requestParams.toJSONString());
		
		// Response Object
		Response response = httpRequest.request(Method.POST, "/posts");
		
		JsonPath jsonpath = response.jsonPath();
		System.out.println(jsonpath.get("title"));
		System.out.println(jsonpath.get("body"));
		
		String responseBody = response.getBody().asString();
		int responseCode = response.getStatusCode();
		String statusLine = response.getStatusLine();
		
		Headers headers = response.headers();
		for(Header h : headers)
		{
			System.out.println(h.getName() + h.getValue());
		}
		
		
		
		System.out.println("Response Body : " + responseBody);
		System.out.println("Response Code : "+ responseCode);
		System.out.println("Status Line : "+ statusLine);
		
		Assert.assertEquals(responseCode, 201);
		Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
		
		
		RestAssured.baseURI = "";
		
		PreemptiveBasicAuthScheme authentication1 = new PreemptiveBasicAuthScheme();
		authentication1.setUserName("");
		authentication1.setPassword("");
		RestAssured.authentication = authentication1;
		
		RequestSpecification httpRequest1 = RestAssured.given();
		
		JSONObject O = new JSONObject();
		O.put("","");
		O.put("","");
		
		httpRequest1.header("Content-type", "application/json; charset utf-8");
		httpRequest1.body(O.toJSONString());
		
		Response response1 = httpRequest1.request(Method.GET,"/url/");
		
		response1.getBody().asString();
		response1.getStatusCode();
		response1.getContentType();
		response1.getStatusLine();
		
		Headers h1 = response.headers();
		for(Header h2 : h1)
		{
			System.out.println(h2.getName() + h2.getValue());
		}
		
		JsonPath js = response1.jsonPath();
		
		js.get("");
		
	
	}	
	
}

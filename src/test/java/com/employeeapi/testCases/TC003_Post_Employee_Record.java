package com.employeeapi.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.RestAssuredFrameworl;
import com.employeeapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;

public class TC003_Post_Employee_Record extends RestAssuredFrameworl{
	
	String empName = RestUtils.empName();
	String empSal = RestUtils.empSal();
	String empAge = RestUtils.empAge();
	
	@BeforeClass
	void post_employee_record() throws InterruptedException
	{
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		
		JSONObject O = new JSONObject();
		O.put("name", empName);
		O.put("empSal", empSal);
		O.put("empAge", empAge);
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(O.toJSONString());
		
		response = httpRequest.request(Method.POST, "/create");
		Thread.sleep(5);
	}
	
	@Test
	void checkResponseBody()
	{
		logger.info("------------------- Checking Rrsponse Body------------------------");
		String responseBody = response.getBody().asString();
		logger.info("Response Body  ==>"+responseBody);
		Assert.assertTrue(responseBody.contains("id"));
	}
	
	@Test
	void checkStatusCode()
	{
		logger.info("-------------------- Checking Status Code --------------------------");
		int statusCode = response.getStatusCode();
		logger.info("Status Code ===>"+statusCode);
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	void checkStatusLine()
	{
		logger.info("-------------------- Checking Status Line --------------------------");
		String statusLine = response.getStatusLine();
		logger.info("Status Line ===>"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test
	void checkContentType()
	{
		logger.info("-------------------- Checking Content Type --------------------------");
		String contentType = response.getContentType();
		logger.info("Content Type ===>"+contentType);
		Assert.assertEquals(contentType, "application/json");
	}
	
	@Test
	void checkServerType()
	{
		logger.info("-------------------- Checking Server Type --------------------------");
		String serverType = response.header("Server");
		logger.info("Server Type ===>"+serverType);
		Assert.assertEquals(serverType, "nginx");
	}
	
	@Test
	void checkContentEncoding()
	{
		logger.info("-------------------- Checking Content Encoding --------------------------");
		String contentEncoding = response.header("Content-Encoding");
		logger.info("Content Encoding ===>"+contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
	}
	
	@Test
	void checkContentLength()
	{
		logger.info("-------------------- Checking Content Length -----------------------------");
		int length = response.contentType().length();
		logger.info("Content Length ===> "+length);
		Assert.assertTrue(length<800);
	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("----------------- End of TC003 -------------------");
	}
	
	
}

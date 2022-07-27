package com.employeeapi.testCases;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.RestAssuredFrameworl;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_Get_All_Employees extends RestAssuredFrameworl
{
	
	@BeforeClass
	void getAllEmployees() throws InterruptedException
	{
		logger.info("------------------Started TC001_Get_All_Employees----------------");
		
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employees");
		Thread.sleep(3);
	}
	
	@Test
	void checkResponseBody()
	{
		logger.info("------------------- Checking Rrsponse Body------------------------");
		String responseBody = response.getBody().asString();
		logger.info("Response Body  ==>"+responseBody);
		Assert.assertTrue(responseBody!=null);
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
	void checkResponseTime()
	{
		logger.info("-------------------- Checking Response Time --------------------------");
		long responseTime = response.getTime();
		logger.info("Response Time ===>"+responseTime);
		Assert.assertTrue(responseTime<2000);
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
	
	@AfterClass
	void tearDown()
	{
		logger.info("------------------------ Finished TC001_Get_All_Employees------------------");
	}

}

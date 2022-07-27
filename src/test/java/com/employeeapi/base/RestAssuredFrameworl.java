package com.employeeapi.base;

import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredFrameworl {
	// ------ Analysis ----------
	// Main objective of framework
	// reusability - duplication should be eliminated
	// maintainability - another guy should easily understand framework, easy to understand test casese
	// Ananlysis when designing framewrok
	// 1. What kind of framework we need to choose cucmber robot testNG JUnit are predefined framewrok
	// for using this framework we use some of the feature but we need to customize some of the featrues
	//  - Data driven, hybrid, keyword driven, modular framework, etc.
	// Hybrid Approch - mutiple tools can be used
	// restAssured -> TestNG -> Maven -> Jenkins(CI/CD) -> GIT, GITHUB 
	// Maven (we can run test cases from command line and jenkins)
	// Jenkins -> to run our test cases remotely in Continuous Integration Enviornment
	// --------------- Implementation of Automation Framework-----------------------------------
	// Implementation -> Exceution -> Maintanance
	// 1. Implementation / Development
	//  Create Maven Project -> update pom.xml -> Create Folder Structure
	// Folder Structure : Below are main folders :
	// Project_Name -> Base (package, Common utitlities, reusable) -> Test Cases(package, Actual Test Cases) -> Utilities (package, reports, excel read, test Data)
	// -> logs (folder, Generate Logs) -> reports (folder, Generate Folder) -> pom.xml -> TestNg.xml(Create test cases as a suite)
	// How many ways test cases can be executed?
	// testng.xml - pom.xml (add certain number of plugin) - Command Prompt - run.bat (windows executable file) - Jenkins
	// pom.xml - 2 plugins are required 1. maven-compiler-plugin 2.maven-surefire-plugin
	// command prompt - maven two types (plugin with eclipse, complete soft on OS) - to run project on cmd - install maven soft on OS
	// download maven - extract zip - go to bin directory copy path - open my pc propeties - advance settings - enviornment variables - botttom click on path - click new  - paste path - click ok three times
	// veify that maven installed - open cmd in the project path - give command mvn clean install
	// run.bat -> create run.bat file -> inside run.bat file add teo coommands -> cd path to the preoject and mvn clean install
	// Jenkins -> maven is a build tool -> using maven devops build is created -> using jenkins devops test cases are executed aginst the created build
	// most of the smoke and sanity test is done in devops enviornment. whenever new build is generated automatioc smoke and sanity test will be secuted against the build through jenkins thats called Continuous Integration Process
	// install Jenkins - Generallly jenkins is installed in devops enviornment and they will give you the access to configure your project - minimal level access on jenkins
	// two ways to install jenkins 1. download .exe and install permanent approch 2.jenkins war file temporyr approch
	// install jenkins.war -> create folder in c drive and copy jenkins.war -> open cmd from the location -> java -jar jenkins.war 
	// create new project - give project name - in the build section select windows batch file - give path run.bat - apply and save - click on run build
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID = "51840";
	
	public Logger logger;
	
	@BeforeClass
	public void setUp()
	{
		logger = Logger.getLogger("EmployeesRestAPIssss");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
	
	
}

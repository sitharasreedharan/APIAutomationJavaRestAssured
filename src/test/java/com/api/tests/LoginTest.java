package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured .*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class LoginTest {
	
	@Test
	public void loginTest(){
		
		RequestSpecification reqSpec = given().baseUri("http://64.227.160.186:8080").header("Content-Type","application/json").body("{\"username\" : \"apiuser\" , \"password\" : \"pass1234\"}");
		Response response = reqSpec.post("/api/auth/login");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode , 200, "Status code does not match");
		System.out.println(response.getBody().asPrettyString());
		

}
}

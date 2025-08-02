package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class LoginTest2 {
	@Test
	public void loginTest() {
		AuthService authService = new AuthService();
		//Response response = authService.login("{\"username\" : \"apiuser\" , \"password\" : \"pass1234\"}");
		//System.out.println(response.getBody().asPrettyString());
	}

}

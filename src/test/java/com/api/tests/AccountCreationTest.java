package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignupRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	@Test
	public void createAccountTest()
	{
		SignupRequest signupRequest = new SignupRequest.Builder()
		.userName("Sithara1")
		.email("Sithara1@gmil.com")
		.firstName("Sithara1")
		.lastName("test1")
		.password("pass123")
		.mobileNumber("0410222333")
		.build();
		
		AuthService authService = new AuthService();
		Response response = authService.signUp(signupRequest);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		Assert.assertEquals(response.statusCode(), 200);
	}

}

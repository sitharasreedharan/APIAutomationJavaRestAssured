package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)

public class LoginTest3 {
	@Test
	public void loginTest() {
	LoginRequest loginRequest = new LoginRequest("apiuser","pass1234");
	AuthService authService = new AuthService();
	Response response = authService.login(loginRequest);
	System.out.println(response.getBody().asPrettyString());
	LoginResponse loginResponse = response.as(LoginResponse.class);
	System.out.println(loginResponse.getToken());
	System.out.println(loginResponse.getEmail());
	System.out.println(loginResponse.getId());
	Assert.assertTrue(loginResponse.getToken() != null);
	Assert.assertEquals(loginResponse.getEmail(),"techwithsithara@gmail.com");
	}
}

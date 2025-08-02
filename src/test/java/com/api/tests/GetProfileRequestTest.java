package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.SignupRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {
	@Test
	public void getProfileRequestTest()
	{
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("Sithara1","pass123"));
		LoginResponse loginResponse = response.as(LoginResponse.class); //deserialization
		String token = loginResponse.getToken();
		
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getProfile(token);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getFirstName());
		
		
	}

}

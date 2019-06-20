package StepDefinition;

import java.io.IOException;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;


public class CallAPI {
	public static HttpResponse httpResponse;
	public static HttpPost httpPost;
	public static HttpGet httpget;
	public static String responseString;
	public static JSONObject jsonObject;
	public static String TokenAuthorization;
	
	public static CloseableHttpClient client;
	public static HttpUriRequest request;
	public static String json;
	public static StringEntity entity;


	// API or CallPostAPIwithJSON (POST with JSON)
	@Given("^user testing the JSON Status Code$")
	public void user_testing_the_JSON_Status_Code() throws ClientProtocolException, IOException {
		client = HttpClients.createDefault();
	    json = "{\"password\": \"admin\",\"rememberMe\": true,\"username\": \"admin\"}";
	    entity = new StringEntity(json);
	    request = RequestBuilder.post()
				.setUri("http://localhost:8080/api/authenticate")
				.setEntity(entity)
				.setHeader("Accept", "application/json")
				.setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
				.build();
	}
	 
	@When("^user sends the JSON API request$")
	public void user_sends_the_JSON_API_request() throws ClientProtocolException, IOException {
		httpResponse = client.execute(request);
	}
	
	@Then("^user verifies the JSON return code$")
	public void user_verifies_the_JSON_return_code() throws ClientProtocolException, IOException, JSONException {
	    responseString = new BasicResponseHandler().handleResponse(httpResponse);
		System.out.println("Post Response : " + responseString);
		
		jsonObject = new JSONObject(responseString);
		TokenAuthorization = jsonObject.getString("id_token");
		System.out.println("JSON id_toke : " + TokenAuthorization);
		
	    System.out.println("JSON Status Code : " + httpResponse.getStatusLine().getStatusCode());
	    Assert.assertEquals(200, httpResponse.getStatusLine().getStatusCode());
	    client.close();
	}

	// API or CallGetAPIwithJSON (GET User Resource)
	@Given("^user testing the Get Authorization")
	public void user_testing_the_Get_Authorization() throws ClientProtocolException, IOException {
		client = HttpClients.createDefault();
		request = RequestBuilder.get()
				.setUri("http://localhost:8080/api/users?queryParams=user")
				.setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
				.setHeader("Authorization", "Bearer " + TokenAuthorization)
				.build();
	}

	@When("^user sends the Authorization API request$")
	public void user_sends_the_Authorization_API_request() throws ClientProtocolException, IOException, AuthenticationException {
		httpResponse = client.execute(request);
	}

	@Then("^user verifies the Authorization return code and values$")
	public void user_verifies_the_Authorization_return_code_and_values() throws ClientProtocolException, IOException, JSONException {
		responseString = new BasicResponseHandler().handleResponse(httpResponse);
		System.out.println("Get response : " + responseString);
		System.out.println("Get Status Code : " + httpResponse.getStatusLine().getStatusCode());
		
		JSONObject obj = new JSONObject("{ \"userdata\": " + responseString + "}");
		JSONArray arr = obj.getJSONArray("userdata");
		for (int i = 0; i < arr.length(); i++) {
            String UserLogin = arr.getJSONObject(i).getString("login");
            System.out.println(UserLogin);
            if (UserLogin.equals("system")) {
            	System.out.println("Authorities : " + arr.getJSONObject(i).getString("authorities"));
            }
        }
	    client.close();
	}
	
	// API or CallPutAPIwithJSON
	@Given("^User try to update the user roles$")
	public void user_try_to_update_the_user_roles() throws ClientProtocolException, IOException {
		client = HttpClients.createDefault();
		json = "{\"id\" : 4,\"login\" : \"user\",\"firstName\" : \"User\",\"lastName\" : \"User\",\"email\" : \"user@localhost\",\"imageUrl\" : \"test3.com\",\"activated\" : true,\"langKey\" : \"en\",\"createdBy\" : \"system\",\"createdDate\" : null,\"lastModifiedBy\" : \"system\",\"lastModifiedDate\" : null,\"authorities\" : [ \"ROLE_USER\" ]}";
	    entity = new StringEntity(json);
		request = RequestBuilder.put()
				.setUri("http://localhost:8080/api/users")
				.setEntity(entity)
				.setHeader("Accept", "application/json")
				.setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
				.setHeader("Authorization", "Bearer " + TokenAuthorization)
				.build();
	}

	@When("^User sends the imageUrl values for user login$")
	public void user_sends_the_imageUrl_values_for_user_login() throws ClientProtocolException, IOException {
		httpResponse = client.execute(request);
	}

	@Then("^User receives success status code$")
	public void user_receives_success_status_code() throws ClientProtocolException, IOException {
		responseString = new BasicResponseHandler().handleResponse(httpResponse);
		System.out.println("PUT response : " + responseString);
		System.out.println("PUT Status Code : " + httpResponse.getStatusLine().getStatusCode());
		client.close();
	}

	// API or NewUserPostAPIwithJSON (Create New userId)
	@Given("^user creates new userid$")
	public void user_creates_new_userid() throws ClientProtocolException, IOException {
		client = HttpClients.createDefault();
	    json = "{\"login\" : \"sample\",\"firstName\" : \"sample\",\"lastName\" : \"sample\",\"email\" : \"sample@localhost\",\"imageUrl\" : \"sample.com\",\"activated\" : true,\"langKey\" : \"en\",\"createdBy\" : \"test\",\"createdDate\" : null,\"lastModifiedBy\" : \"test\",\"lastModifiedDate\" : null,\"authorities\" : [ \"ROLE_USER\" ]}";
	    entity = new StringEntity(json);
	    request = RequestBuilder.post()
				.setUri("http://localhost:8080/api/users")
				.setEntity(entity)
				.setHeader("Accept", "application/json")
				.setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
				.setHeader("Authorization", "Bearer " + TokenAuthorization)
				.build();
	}

	@When("^user sends the new userid request$")
	public void user_sends_the_new_userid_request() throws ClientProtocolException, IOException {
		httpResponse = client.execute(request);
	}

	@Then("^user verifies the new userid return code$")
	public void user_verifies_the_new_userid_return_code() throws ClientProtocolException, IOException {
		responseString = new BasicResponseHandler().handleResponse(httpResponse);
		System.out.println("POST New User response : " + responseString);
		System.out.println("POST New User Status Code : " + httpResponse.getStatusLine().getStatusCode());
		client.close();
	}
	
	// API or UserDeleteAPI (Delete userId)
	@Given("^user deletes userid$")
	public void user_deletes_userid() throws ClientProtocolException, IOException {
		client = HttpClients.createDefault();
		request = RequestBuilder.delete()
				.setUri("http://localhost:8080/api/users/sample")
				.setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
				.setHeader("Authorization", "Bearer " + TokenAuthorization)
				.build();
	}

	@When("^user sends the delete request$")
	public void user_sends_the_delete_request() throws ClientProtocolException, IOException {
		httpResponse = client.execute(request);
	}

	@Then("^user verifies the delete userid return code$")
	public void user_verifies_the_delete_userid_return_code() throws ClientProtocolException, IOException {
		responseString = new BasicResponseHandler().handleResponse(httpResponse);
		System.out.println("Delete User response : " + responseString);
		System.out.println("Delete User Status Code : " + httpResponse.getStatusLine().getStatusCode());
		client.close();
	}

}

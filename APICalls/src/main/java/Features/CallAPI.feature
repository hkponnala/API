@API
Feature: Call APIs

   # POST with JSON
   @CallPostAPIwithJSON
   Scenario: Testing the JSON Status Code
   	Given user testing the JSON Status Code
    When user sends the JSON API request
    Then user verifies the JSON return code
   
   # GET with JSON
   @CallGetAPIwithJSON
   Scenario: Testing Get Authorization Status
   	Given user testing the Get Authorization
    When user sends the Authorization API request
    Then user verifies the Authorization return code and values
    
   # PUT with JSON
   @CallPutAPIwithJSON
   Scenario: Testing PUT Authorization Status
   	Given User try to update the user roles
	When User sends the imageUrl values for user login
	Then User receives success status code

   # POST with JSON (Create New User)
   @NewUserPostAPIwithJSON
   Scenario: Adding new user
   	Given user creates new userid
    When user sends the new userid request
    Then user verifies the new userid return code
    
   # Delete with JSON (Delete User)
   @UserDeleteAPI
   Scenario: Deleting user
   	Given user deletes userid
    When user sends the delete request
    Then user verifies the delete userid return code
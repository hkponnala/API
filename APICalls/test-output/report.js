$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Order-002/CallAPI.feature");
formatter.feature({
  "line": 2,
  "name": "Call APIs",
  "description": "",
  "id": "call-apis",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@API"
    }
  ]
});
formatter.scenario({
  "comments": [
    {
      "line": 4,
      "value": "# POST with JSON"
    }
  ],
  "line": 6,
  "name": "Testing the JSON Status Code",
  "description": "",
  "id": "call-apis;testing-the-json-status-code",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@CallPostAPIwithJSON"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "user testing the JSON Status Code",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "user sends the JSON API request",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "user verifies the JSON return code",
  "keyword": "Then "
});
formatter.match({
  "location": "CallAPI.user_testing_the_JSON_Status_Code()"
});
formatter.result({
  "duration": 847991139,
  "status": "passed"
});
formatter.match({
  "location": "CallAPI.user_sends_the_JSON_API_request()"
});
formatter.result({
  "duration": 494385634,
  "status": "passed"
});
formatter.match({
  "location": "CallAPI.user_verifies_the_JSON_return_code()"
});
formatter.result({
  "duration": 7181087,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 11,
      "value": "# GET with JSON"
    }
  ],
  "line": 13,
  "name": "Testing Get Authorization Status",
  "description": "",
  "id": "call-apis;testing-get-authorization-status",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 12,
      "name": "@CallGetAPIwithJSON"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "user testing the Get Authorization",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "user sends the Authorization API request",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "user verifies the Authorization return code and values",
  "keyword": "Then "
});
formatter.match({
  "location": "CallAPI.user_testing_the_Get_Authorization()"
});
formatter.result({
  "duration": 7764198,
  "status": "passed"
});
formatter.match({
  "location": "CallAPI.user_sends_the_Authorization_API_request()"
});
formatter.result({
  "duration": 51639766,
  "status": "passed"
});
formatter.match({
  "location": "CallAPI.user_verifies_the_Authorization_return_code_and_values()"
});
formatter.result({
  "duration": 4560783,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 18,
      "value": "# PUT with JSON"
    }
  ],
  "line": 20,
  "name": "Testing PUT Authorization Status",
  "description": "",
  "id": "call-apis;testing-put-authorization-status",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 19,
      "name": "@CallPutAPIwithJSON"
    }
  ]
});
formatter.step({
  "line": 21,
  "name": "User try to update the user roles",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "User sends the imageUrl values for user login",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "User receives success status code",
  "keyword": "Then "
});
formatter.match({
  "location": "CallAPI.user_try_to_update_the_user_roles()"
});
formatter.result({
  "duration": 10221799,
  "status": "passed"
});
formatter.match({
  "location": "CallAPI.user_sends_the_imageUrl_values_for_user_login()"
});
formatter.result({
  "duration": 271973340,
  "status": "passed"
});
formatter.match({
  "location": "CallAPI.user_receives_success_status_code()"
});
formatter.result({
  "duration": 873814,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 25,
      "value": "# POST with JSON (Create New User)"
    }
  ],
  "line": 27,
  "name": "Adding new user",
  "description": "",
  "id": "call-apis;adding-new-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 26,
      "name": "@NewUserPostAPIwithJSON"
    }
  ]
});
formatter.step({
  "line": 28,
  "name": "user creates new userid",
  "keyword": "Given "
});
formatter.step({
  "line": 29,
  "name": "user sends the new userid request",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "user verifies the new userid return code",
  "keyword": "Then "
});
formatter.match({
  "location": "CallAPI.user_creates_new_userid()"
});
formatter.result({
  "duration": 3283059,
  "status": "passed"
});
formatter.match({
  "location": "CallAPI.user_sends_the_new_userid_request()"
});
formatter.result({
  "duration": 144747561,
  "status": "passed"
});
formatter.match({
  "location": "CallAPI.user_verifies_the_new_userid_return_code()"
});
formatter.result({
  "duration": 947200,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 32,
      "value": "# Delete with JSON (Delete User)"
    }
  ],
  "line": 34,
  "name": "Deleting user",
  "description": "",
  "id": "call-apis;deleting-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 33,
      "name": "@UserDeleteAPI"
    }
  ]
});
formatter.step({
  "line": 35,
  "name": "user deletes userid",
  "keyword": "Given "
});
formatter.step({
  "line": 36,
  "name": "user sends the delete request",
  "keyword": "When "
});
formatter.step({
  "line": 37,
  "name": "user verifies the delete userid return code",
  "keyword": "Then "
});
formatter.match({
  "location": "CallAPI.user_deletes_userid()"
});
formatter.result({
  "duration": 2761956,
  "status": "passed"
});
formatter.match({
  "location": "CallAPI.user_sends_the_delete_request()"
});
formatter.result({
  "duration": 43361292,
  "status": "passed"
});
formatter.match({
  "location": "CallAPI.user_verifies_the_delete_userid_return_code()"
});
formatter.result({
  "duration": 493227,
  "status": "passed"
});
});
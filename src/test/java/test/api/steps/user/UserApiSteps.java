package test.api.steps.user;

import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static test.api.methods.Users.*;
import test.api.requests.BodyArgs;
import test.api.requests.user.createUserRequest;
import test.api.responses.Result;

import static test.api.roles.UserRoles.ADMIN;
import static utils.EnvProperties.*;
import test.api.requests.user.UserId;
import test.api.steps.BaseApiSteps;

public class UserApiSteps extends BaseApiSteps {
    @Step("Create user")
    public String createUser(String username, String pass) {
        createUserRequest args = createUserRequest.builder()
                .username(username)
                .name(username)
                .password(pass)
                .email(username + "@mail.com")
                .role(ADMIN.getRole())
                .build();

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(args)
                .method(CREATE_USER)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.prettyPrint();
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }
    @Step("Remove user")
    public boolean deleteUser(Integer userId) {

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(new UserId(userId))
                .method(DELETE_USER)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.prettyPrint();
        response.then().statusCode(200);
        return (boolean) response.as(Result.class).getResult();
    }
    @Step("Get user")
    public JsonPath getUser(Integer userId) {

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(new UserId(userId))
                .method(GET_USER)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.prettyPrint();
        response.then().statusCode(200);
        JsonPath jsonPath = response.jsonPath();
        return jsonPath;
    }
}

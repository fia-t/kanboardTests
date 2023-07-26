package test.api.steps.project;

import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import test.api.requests.BodyArgs;
import test.api.requests.project.ProjectId;
import test.api.requests.project.createProjectRequest;
import test.api.requests.user.UserId;
import test.api.responses.Result;
import test.api.steps.BaseApiSteps;

import static test.api.methods.Projects.*;
import static test.api.methods.Users.GET_USER;
import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;

public class ProjectApiSteps extends BaseApiSteps {
    @Step("Create project")
    public String createProject(String projectName, Integer userId) {
        createProjectRequest args = createProjectRequest.builder()
                .name(projectName)
                .owner_id(userId)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(args)
                .method(CREATE_PROJECT)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.prettyPrint();
        response.then().statusCode(200);
        Result result = response.as(Result.class);

        return result.getResult().toString();
    }
    @Step("Remove project")
    public boolean removeProject(String projectId) {

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(new ProjectId(Integer.valueOf(projectId)))
                .method(REMOVE_PROJECT)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return (boolean) response.as(Result.class).getResult();
    }
    @Step("Get project")
    public JsonPath getProject(Integer projectId) {

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(new ProjectId(projectId))
                .method(GET_PROJECT)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.prettyPrint();
        response.then().statusCode(200);
        JsonPath jsonPath = response.jsonPath();
        return jsonPath;
    }
}

package test.api.steps.projectuser;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import test.api.requests.BodyArgs;
import test.api.requests.projectuser.createProjectUserRequest;
import test.api.requests.projectuser.removeProjectUserRequest;
import test.api.responses.Result;
import test.api.steps.BaseApiSteps;

import static test.api.methods.ProjectPermission.ADD_PROJECT_USER;
import static test.api.methods.ProjectPermission.REMOVE_PROJECT_USER;
import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;

public class ProjectUserApiSteps extends BaseApiSteps {
    @Step("Create user-project")
    public String addProjectUser(Integer projectId, Integer userId) {
        createProjectUserRequest args = createProjectUserRequest.builder()
                .project_id(projectId)
                .user_id(userId)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(args)
                .method(ADD_PROJECT_USER)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.prettyPrint();
        response.then().statusCode(200);
        Result result = response.as(Result.class);

        return result.getResult().toString();
    }
    @Step("Remove user-project")
    public boolean removeProjectUser(String projectId, String userId) {
        removeProjectUserRequest args = removeProjectUserRequest.builder()
                .project_id(Integer.valueOf(projectId))
                .user_id(Integer.valueOf(userId))
                .build();

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(args)
                .method(REMOVE_PROJECT_USER)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return (boolean) response.as(Result.class).getResult();
    }
}

package test.api.steps.task;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import test.api.requests.BodyArgs;
import test.api.requests.task.TaskId;
import test.api.requests.task.createTaskRequest;
import test.api.responses.Result;
import test.api.steps.BaseApiSteps;

import static test.api.methods.Tasks.CREATE_TASK;
import static test.api.methods.Tasks.REMOVE_TASK;
import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;

public class TaskApiSteps extends BaseApiSteps {
    @Step("Create task")
    public String createTask(Integer project_id, Integer userId, String description, String title, String color) {
        createTaskRequest args = createTaskRequest.builder()
                .owner_id(userId)
                .creator_id(userId)
                .description(description)
                .title(title)
                .project_id(project_id)
                .color_id(color)
//                .column_id(column_id)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(args)
                .method(CREATE_TASK)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.prettyPrint();
        response.then().statusCode(200);
        Result result = response.as(Result.class);

        return result.getResult().toString();
    }
    @Step("Remove Task")
    public boolean removeTask(Integer taskId) {

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(new TaskId(taskId))
                .method(REMOVE_TASK)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return (boolean) response.as(Result.class).getResult();
    }
}
